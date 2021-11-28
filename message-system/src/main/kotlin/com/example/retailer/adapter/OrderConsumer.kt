package com.example.retailer.adapter

import com.example.retailer.RatailerConfigaration.Companion.RETAILER_QUEUE
import com.example.retailer.api.distributor.OrderInfo
import com.example.retailer.storage.OrderStorage
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class OrderConsumer (private val storage: OrderStorage) {

    @RabbitListener(queues = [RETAILER_QUEUE])
    fun handleDistributedOrder(orderInfo: OrderInfo) {
        storage.updateOrder(orderInfo)

    }
}