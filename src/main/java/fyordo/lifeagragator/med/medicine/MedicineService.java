package fyordo.lifeagragator.med.medicine;

import com.querydsl.core.types.dsl.BooleanExpression;
import fyordo.lifeagragator.med.base.exceptions.ModelNotFoundException;
import fyordo.lifeagragator.med.base.utils.WorkspaceUtils;
import fyordo.lifeagragator.med.medicine.request.MedicineCreateRequest;
import fyordo.lifeagragator.med.medicine.request.MedicineFilter;
import fyordo.lifeagragator.med.medicine.request.MedicineUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MedicineService {
    private final MedicineRepository medicineRepository;

    public List<Medicine> getMedicines(MedicineFilter medicineFilter){
        return (List<Medicine>)medicineRepository
                .findAll(generateFilter(medicineFilter));
    }

    private BooleanExpression generateFilter(MedicineFilter medicineFilter) {
        QMedicine qMedicine = QMedicine.medicine;
        BooleanExpression result = qMedicine.isNotNull();

        if (medicineFilter.getOnlyMy()){
            result = result.and(qMedicine.createdUserId.eq(WorkspaceUtils.getUserId()));
        }

        if (medicineFilter.getSearch() != null){
            result = result.and(qMedicine.title.containsIgnoreCase(medicineFilter.getSearch()));
        }

        return result;
    }


    public Medicine getMedicineById(Long id){
        return medicineRepository
                .findById(id)
                .filter((Medicine medicine) -> Objects.equals(medicine.getCreatedUserId(), WorkspaceUtils.getUserId()))
                .orElseThrow(ModelNotFoundException::new);
    }

    public Medicine createMedicine(MedicineCreateRequest data){
        Medicine medicine = new Medicine(data);
        medicine.setCreatedUserId(WorkspaceUtils.getUserId());
        return medicineRepository.save(medicine);
    }

    public Medicine updateMedicine(MedicineUpdateRequest data){
        getMedicineById(data.getId());

        Medicine medicine = new Medicine(data);
        medicine.setCreatedUserId(WorkspaceUtils.getUserId());
        return medicineRepository.save(medicine);
    }

    public void deleteMedicineById(Long id){
        Medicine medicine = getMedicineById(id);
        medicineRepository.delete(medicine);
    }
}
