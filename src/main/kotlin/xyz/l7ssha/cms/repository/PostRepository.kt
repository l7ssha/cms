package xyz.l7ssha.cms.repository

import org.springframework.data.repository.CrudRepository
import xyz.l7ssha.cms.entity.Post

interface PostRepository: CrudRepository<Post, String> {
}
