package fyordo.lifeagragator.med.tag;

import fyordo.lifeagragator.med.tag.request.TagCreateRequest;
import fyordo.lifeagragator.med.tag.request.TagUpdateRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;

@Getter
@Setter
@Entity
@Table(name = "tag")
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", length = 31, nullable = false)
    private String title;

    @Column(name = "color", length = 7, nullable = false)
    private String color;

    @Column(name = "text_color", length = 7)
    private String textColor;

    @Column(name = "created_user_id", nullable = false)
    private Long createdUserId;

    public Tag(TagCreateRequest data){
        title = data.getTitle();
        color = data.getColor();
        textColor = data.getTextColor();
    }

    public Tag(TagUpdateRequest data){
        id = data.getId();
        title = data.getTitle();
        color = data.getColor();
        textColor = data.getTextColor();
    }
}