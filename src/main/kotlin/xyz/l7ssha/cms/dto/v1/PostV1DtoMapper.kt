package xyz.l7ssha.cms.dto.v1

import org.mapstruct.Mapper
import org.springframework.stereotype.Component
import xyz.l7ssha.cms.entity.Post

@Mapper(componentModel = "spring")
@Component
interface PostV1DtoMapper {
    fun postInputDtoToPost(inputDto: PostInputDto): Post;
}
