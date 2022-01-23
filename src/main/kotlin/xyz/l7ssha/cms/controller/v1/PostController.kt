package xyz.l7ssha.cms.controller.v1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xyz.l7ssha.cms.entity.Post
import xyz.l7ssha.cms.repository.PostRepository
import java.util.*

@RestController
@RequestMapping("/api/v1/posts")
class PostController(@Autowired val postRepository: PostRepository) {

    @GetMapping
    fun getCollectionAction(): Iterable<Post> =  postRepository.findAll()

    @GetMapping("/{id}")
    fun getSingleCollection(@PathVariable id: String): Optional<Post> = postRepository.findById(id)
}
