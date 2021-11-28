package com.example.retailer.api.distributor

import javax.persistence.*

/**
 * Уведомление об изменении заказа
 */

@Entity
@Table(name = "info")
data class OrderInfo(

    /**
     * Уникальный идентификатор заказа
     *
     * @see com.example.retailer.api.distributor.Item#id
     */
    @Id
    @Column(name = "order_id")
    val orderId: String,

    /**
     * Статус заказа:
     *  Created
     *
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var status: OrderStatus,

    /**
     * Контрольная сумма
     */
    @Column(nullable = false)
    val signature: String,

)