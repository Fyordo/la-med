package fyordo.lifeagragator.med.tag.dto

import fyordo.lifeagragator.med.base.utils.getUserId

data class TagDeleteMultipleRequest(
    val ids: List<Long>
)
