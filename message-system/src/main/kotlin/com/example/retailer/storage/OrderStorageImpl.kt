package com.example.retailer.storage

import com.example.retailer.api.distributor.Order
import com.example.retailer.api.distributor.OrderInfo
import com.example.retailer.api.distributor.OrderStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderStorageImpl(): OrderStorage {
    @Autowired
    lateinit var repository: OrderRepository
    @Autowired
    lateinit var infoRepository: InfoRepository

    override fun createOrder(draftOrder: Order): PlaceOrderData {

        draftOrder.id = UUID.randomUUID().toString()
        val orderData = repository.save(draftOrder)
        val orderInfo = infoRepository.save(OrderInfo(orderData.id!!, OrderStatus.CREATED, draftOrder.hashCode().toString()))

        return PlaceOrderData(orderData, orderInfo)

    }

    override fun updateOrder(order: OrderInfo): Boolean {

        infoRepository.save(order)
        return true
    }

    override fun getOrderInfo(id: String): OrderInfo? {
        return  infoRepository.findById(id).orElse(null)
    }

}