package fyordo.lifeagragator.med.medicine.request;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineCreateRequest {
    @NonNull
    private String title;

    @Nullable
    private String photoUrl;
}
