package fyordo.lifeagragator.med.medicine.dto;

import fyordo.lifeagragator.med.medicine.Medicine;
import fyordo.lifeagragator.med.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MedicineDto {
    private Long id;
    private String title;
    private String photoUrl;


    public MedicineDto(Medicine medicine){
        id = medicine.getId();
        title = medicine.getTitle();
        photoUrl = medicine.getPhotoUrl();
    }
}
