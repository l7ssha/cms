package xyz.l7ssha.cms.validation

import javax.validation.Constraint
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PostTitleExistValidator::class])
annotation class PostTitleExist(
    val message: String = "Title already exists",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<*>> = []
)
