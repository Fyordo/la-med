package fyordo.lifeagragator.med.tag

import fyordo.lifeagragator.med.base.utils.getUserId
import fyordo.lifeagragator.med.tag.dto.TagCreateRequest
import fyordo.lifeagragator.med.tag.dto.TagUpdateRequest
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Entity
@Table(name = "tag")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Tag{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "title", length = 63)
    var title: String? = null

    @Column(name = "color", length = 7)
    var color: String? = null

    @Column(name = "text_color", length = 7)
    var textColor: String? = null

    @Column(name = "created_user_id")
    var createdUserId: Long? = null

    constructor(data: TagCreateRequest){
        title = data.title
        color = data.color
        textColor = data.textColor
        createdUserId = getUserId()
    }

    constructor(data: TagUpdateRequest){
        id = data.id
        title = data.title
        color = data.color
        textColor = data.textColor
        createdUserId = data.createdUserId ?: getUserId()
    }
}