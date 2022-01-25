package xyz.l7ssha.cms.dto.v1

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length
import org.springframework.validation.annotation.Validated
import xyz.l7ssha.cms.validation.PostTitleExist
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Validated
class PostInputDto {
    @JsonProperty("title")
    @NotNull
    @NotBlank
    @Length(max = 30)
    @PostTitleExist
    lateinit var title: String

    @JsonProperty("content")
    @NotBlank
    lateinit var content: String
}
