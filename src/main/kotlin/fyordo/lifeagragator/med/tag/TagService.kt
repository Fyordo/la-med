package fyordo.lifeagragator.med.tag

import fyordo.lifeagragator.med.base.ModelNotFoundException
import fyordo.lifeagragator.med.tag.dto.TagCreateRequest
import fyordo.lifeagragator.med.tag.dto.TagUpdateRequest
import kotlinx.coroutines.*
import mu.KotlinLogging
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.math.log

@Service
class TagService(
    private val tagRepository: TagRepository,
) {
    private val logger = KotlinLogging.logger {}

    fun findAll(): List<Tag> =
        tagRepository.findAll()

    fun findById(id: Long): Tag =
        tagRepository.findById(id)
            .orElseThrow { ModelNotFoundException() }

    fun createTag(data: TagCreateRequest): Tag =
        tagRepository.save(Tag(data))

    fun updateTag(data: TagUpdateRequest) =
        tagRepository.save(Tag(data))

    fun deleteTag(id: Long): Unit =
        tagRepository.delete(findById(id))

    suspend fun deleteTags(ids: List<Long>): Unit = coroutineScope{
        launch (CoroutineName("MULTIPLE_TAG_DELETE") + Dispatchers.IO + SupervisorJob()) {
            for (id in ids){
                launch {
                    if (id == 291L) {
                        throw ModelNotFoundException()
                    }
                    deleteTag(id)
                    logger.info("DELETED_TAG_$id")
                }
            }
        }
    }
}