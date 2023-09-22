package jpabook.jpashop.domain

import javax.persistence.Embeddable

@Embeddable
class Address(
    val city: String? = null,
    val street: String? = null,
    val zipcode: String? = null,
)
