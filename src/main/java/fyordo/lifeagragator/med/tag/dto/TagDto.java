package fyordo.lifeagragator.med.tag.dto;

import fyordo.lifeagragator.med.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TagDto {
    private Long id;
    private String title;
    private String color;

    public TagDto(Tag tag){
        id = tag.getId();
        title = tag.getTitle();
        color = tag.getColor();
    }
}
