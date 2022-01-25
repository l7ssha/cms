package xyz.l7ssha.cms.validation

import org.springframework.beans.factory.annotation.Autowired
import xyz.l7ssha.cms.repository.PostRepository
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PostTitleExistValidator(@Autowired val postRepository: PostRepository): ConstraintValidator<PostTitleExist, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) {
            return false
        }

        return postRepository.getPostByTitle(value) == null
    }
}
