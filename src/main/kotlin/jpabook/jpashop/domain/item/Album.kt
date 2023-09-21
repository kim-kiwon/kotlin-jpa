package jpabook.jpashop.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("A")
class Album(
    val artist: String,

    val etc: String,
): Item()
