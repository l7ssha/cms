package xyz.l7ssha.cms.controller.v1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import xyz.l7ssha.cms.dto.v1.PostInputDto
import xyz.l7ssha.cms.dto.v1.PostV1DtoMapper
import xyz.l7ssha.cms.entity.Post
import xyz.l7ssha.cms.repository.PostRepository
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/posts")

class PostController(@Autowired val postRepository: PostRepository, @Autowired val postV1DtoMapper: PostV1DtoMapper) {
    @GetMapping
    fun getCollectionAction(): Iterable<Post> =  postRepository.findAll()

    @GetMapping("/{id}")
    fun getSingleCollection(@PathVariable id: String): Optional<Post> = postRepository.findById(id)

    @PostMapping
    fun postAction(@Valid @RequestBody postDto: PostInputDto) = postRepository.save(postV1DtoMapper.postInputDtoToPost(postDto))
}
