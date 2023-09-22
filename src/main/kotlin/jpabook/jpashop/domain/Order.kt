package jpabook.jpashop.domain

import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "orders")
class Order(
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: Member,

    // cascade: 해당 필드를 가진 엔티티가 저장 / 삭제될때 Cascade 엔티티도 같이 저장 / 삭제된다.
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    val orderItems: MutableList<OrderItem> = mutableListOf(),

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "delivery_id")
    var delivery: Delivery,

    val orderDate: LocalDateTime, // 주문시간

    @Enumerated(EnumType.STRING)
    val status: OrderStatus, // 주문상태 [ORDER, CANCEL]
) {
//    // 양방향에서는 연관관계 편의 메서드가 있으면 좋다
//    // 반대쪽 엔티티에 설정을 까먹는다면 불일치 발생
//    fun setMember(member: Member) {
//        this.member = member
//        member.orders.add(this)
//    }
//
//    fun addOrderItem(orderItem: OrderItem) {
//        orderItems.add(orderItem)
//        orderItem.order = this
//    }
//
//    fun setDelivery(delivery: Delivery) {
//        this.delivery = delivery
//        delivery.order = this
//    }
}
