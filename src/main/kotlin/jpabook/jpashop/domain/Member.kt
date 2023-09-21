package jpabook.jpashop.domain

import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Member(
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    val id: Long = 0,

    val name: String,

    @Embedded
    val address: Address,

    @OneToMany(mappedBy = "member")
    val orders: MutableList<Order> = mutableListOf(),
    // 필드에서 초기화하고 불변으로 사용하는 것이 좋다.
    // Hibernate 가 래핑 후 사용하므로 중간에 바꿔지면 이슈 있을 수 있음
)
