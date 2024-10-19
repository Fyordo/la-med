package fyordo.lifeagragator.med.tag

import fyordo.lifeagragator.med.tag.dto.TagCreateRequest
import fyordo.lifeagragator.med.tag.dto.TagDeleteMultipleRequest
import fyordo.lifeagragator.med.tag.dto.TagDto
import fyordo.lifeagragator.med.tag.dto.TagUpdateRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tag")
class TagController(
    private val tagService: TagService
) {
    @GetMapping
    fun findAll(): ResponseEntity<List<TagDto>> =
        ResponseEntity.ok(tagService.findAll().map { TagDto(it) })

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TagDto> =
        ResponseEntity.ok(TagDto(tagService.findById(id)))

    @PostMapping
    fun createTag(@RequestBody request: TagCreateRequest): ResponseEntity<TagDto> {
        return ResponseEntity.status(201).body(TagDto(tagService.createTag(request)))
    }

    @PutMapping
    fun updateTag(@RequestBody request: TagUpdateRequest): ResponseEntity<TagDto>{
        return ResponseEntity.status(200).body(TagDto(tagService.updateTag(request)))
    }

    @DeleteMapping("{id}")
    fun deleteTag(@PathVariable id: Long): ResponseEntity<Unit>{
        tagService.deleteTag(id)
        return ResponseEntity.noContent().build()
    }

    @PostMapping("delete-multiple")
    suspend fun deleteTags(@RequestBody request: TagDeleteMultipleRequest): ResponseEntity<Unit>{
        tagService.deleteTags(request.ids)
        return ResponseEntity.noContent().build()
    }
}