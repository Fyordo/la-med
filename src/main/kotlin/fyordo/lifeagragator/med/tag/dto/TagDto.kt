package fyordo.lifeagragator.med.tag.dto

import fyordo.lifeagragator.med.tag.Tag

data class TagDto(
    var id: Long? = null,

    var title: String? = null,

    var color: String? = null,

    var textColor: String? = null
){
    constructor(tag: Tag) : this() {
        this.id = tag.id
        this.title = tag.title
        this.color = tag.color
        this.textColor = tag.textColor
    }
}
