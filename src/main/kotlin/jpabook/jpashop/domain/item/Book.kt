package jpabook.jpashop.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("B")
class Book(
    val author: String,

    val isbn: String,
): Item()
