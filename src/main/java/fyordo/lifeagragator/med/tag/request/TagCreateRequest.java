package fyordo.lifeagragator.med.tag.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagCreateRequest {
    @NonNull
    private String title;

    @NonNull
    private String color;

    @NonNull
    private String textColor;
}
