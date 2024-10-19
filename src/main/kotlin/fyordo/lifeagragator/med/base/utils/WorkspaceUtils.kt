package fyordo.lifeagragator.med.base.utils

import kotlinx.coroutines.withContext
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

fun getUserId(): Long? {
    val requestAttributes = RequestContextHolder
        .currentRequestAttributes()
    val attributes = requestAttributes as ServletRequestAttributes
    val request = attributes.request
    val httpSession = request.getSession(true)

    val attribute = httpSession.getAttribute("userId") ?: return null

    return (attribute as String).toLong()
}