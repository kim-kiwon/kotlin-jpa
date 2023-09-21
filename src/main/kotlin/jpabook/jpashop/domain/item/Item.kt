package jpabook.jpashop.domain.item

import jpabook.jpashop.domain.Category
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
open class Item(
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    val id: Long = 0,

    var name: String? = null,

    var price: Int? = null,

    var stockQuantity: Int? = null,

    @ManyToMany(mappedBy = "items")
    var categories: List<Category> = listOf(),
)
