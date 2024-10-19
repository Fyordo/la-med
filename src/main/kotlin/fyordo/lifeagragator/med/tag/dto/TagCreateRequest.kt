package fyordo.lifeagragator.med.tag.dto

import fyordo.lifeagragator.med.base.utils.getUserId

data class TagCreateRequest(
    val title: String,

    val color: String,

    val textColor: String
)
