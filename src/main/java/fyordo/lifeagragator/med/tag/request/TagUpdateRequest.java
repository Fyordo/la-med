package fyordo.lifeagragator.med.tag.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class TagUpdateRequest extends TagCreateRequest {
    @NonNull
    private Long id;

    public TagUpdateRequest(@NonNull Long id, @NonNull String title, @NonNull String color, @NonNull String textColor) {
        super(title, color, textColor);
        this.id = id;
    }
}
