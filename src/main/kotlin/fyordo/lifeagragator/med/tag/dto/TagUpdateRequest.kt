package fyordo.lifeagragator.med.tag.dto

import fyordo.lifeagragator.med.base.utils.getUserId

data class TagUpdateRequest(
    var id: Long,

    val title: String,

    val color: String,

    val textColor: String,

    val createdUserId: Long? = getUserId()
)
