package jpabook.jpashop

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Member(
    @Id
    @GeneratedValue
    val id: Long,

    @Column
    val username: String,
) {
}
