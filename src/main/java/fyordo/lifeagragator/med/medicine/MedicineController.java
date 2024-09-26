package fyordo.lifeagragator.med.medicine;

import fyordo.lifeagragator.med.base.reponse.ListResponse;
import fyordo.lifeagragator.med.medicine.dto.MedicineDto;
import fyordo.lifeagragator.med.medicine.request.MedicineCreateRequest;
import fyordo.lifeagragator.med.medicine.request.MedicineFilter;
import fyordo.lifeagragator.med.medicine.request.MedicineUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller()
@RequiredArgsConstructor
@RequestMapping("/medicine")
public class MedicineController {
    private final MedicineService medicineService;
    @GetMapping("")
    public ResponseEntity<ListResponse<MedicineDto>> getAllTags(@RequestParam Map<String, String> filter){
        MedicineFilter medicineFilter = new MedicineFilter(filter);
        List<MedicineDto> result = medicineService.getMedicines(medicineFilter).stream().map(MedicineDto::new).toList();
        return ResponseEntity.ok(new ListResponse<>(result));
    }

    @GetMapping("{id}")
    public ResponseEntity<MedicineDto> getTagById(@PathVariable Long id){
        return ResponseEntity.ok(new MedicineDto(medicineService.getMedicineById(id)));
    }

    @PostMapping()
    public ResponseEntity<MedicineDto> createTag(@RequestBody MedicineCreateRequest request){
        return ResponseEntity.status(201).body(
                new MedicineDto(medicineService.createMedicine(request))
        );
    }

    @PutMapping()
    public ResponseEntity<MedicineDto> updateTag(@RequestBody MedicineUpdateRequest request){
        return ResponseEntity.status(201).body(
                new MedicineDto(medicineService.updateMedicine(request))
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTag(@PathVariable Long id){
        medicineService.deleteMedicineById(id);
        return ResponseEntity.status(204).build();
    }
}
