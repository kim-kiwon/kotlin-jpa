package jpabook.jpashop.domain

import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Delivery(
    @Id
    @GeneratedValue
    val id: Long = 0,

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    var order: Order,

    @Embedded
    val address: Address,

    @Enumerated(EnumType.STRING)
    val status: DeliveryStatus, // READY, COMP,
)
