package xyz.l7ssha.cms.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "posts")
open class Post {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    @Column(name = "id", nullable = false, updatable = false)
    open var id: String? = null

    @Column(name = "title", nullable = false)
    open lateinit var title: String

    @Column(name = "content", nullable = false)
    open lateinit var content: String
}
