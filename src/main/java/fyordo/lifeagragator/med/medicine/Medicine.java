package fyordo.lifeagragator.med.medicine;

import fyordo.lifeagragator.med.medicine.request.MedicineCreateRequest;
import fyordo.lifeagragator.med.medicine.request.MedicineUpdateRequest;
import fyordo.lifeagragator.med.tag.Tag;
import fyordo.lifeagragator.med.tag.request.TagCreateRequest;
import fyordo.lifeagragator.med.tag.request.TagUpdateRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "medicine")
@NoArgsConstructor
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", length = 31, nullable = false)
    private String title;

    @Column(name = "photo_url", length = 1023, nullable = false)
    private String photoUrl;

    @Column(name = "created_user_id", nullable = false)
    private Long createdUserId;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "medicine_tags",
            joinColumns = @JoinColumn(name = "medicine_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id"))
    private Set<Tag> tags = new LinkedHashSet<>();

    public Medicine(MedicineCreateRequest data){
        title = data.getTitle();
        photoUrl = data.getPhotoUrl();
    }

    public Medicine(MedicineUpdateRequest data){
        id = data.getId();
        title = data.getTitle();
        photoUrl = data.getPhotoUrl();
    }
}