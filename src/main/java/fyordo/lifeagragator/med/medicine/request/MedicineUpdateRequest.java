package fyordo.lifeagragator.med.medicine.request;

import fyordo.lifeagragator.med.tag.request.TagCreateRequest;
import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MedicineUpdateRequest extends MedicineCreateRequest {
    @NonNull
    private Long id;

    public MedicineUpdateRequest(@NonNull Long id, @NonNull String title, @Nullable String photoUrl) {
        super(title, photoUrl);
        this.id = id;
    }
}
