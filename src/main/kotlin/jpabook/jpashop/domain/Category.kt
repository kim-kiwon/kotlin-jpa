package jpabook.jpashop.domain

import jpabook.jpashop.domain.item.Item
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Category(
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    val id: Long = 0,

    val name: String,

    // 실무에선 비권장. 조인 테이블에 컬럼 추가가 불가능하다
    @ManyToMany
    @JoinTable(name = "category_item",
        joinColumns = [JoinColumn(name = "category_id")],
        inverseJoinColumns = [JoinColumn(name = "item_id")],
    )
    val items: List<Item> = listOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    var parent: Category, // 상위 카테고리

    @OneToMany(mappedBy = "parent")
    val child: MutableList<Category> = mutableListOf(), // 하위 카테고리. parent 와 연관관계 매핑
) {
    // 연관관계 편의 메서드
    fun addChildCategory(child: Category) {
        this.child.add(child)
        child.parent = this
    }
}
