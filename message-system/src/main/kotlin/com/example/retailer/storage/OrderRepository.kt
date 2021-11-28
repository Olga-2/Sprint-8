package com.example.retailer.storage

import com.example.retailer.api.distributor.Order
import com.example.retailer.api.distributor.OrderInfo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : CrudRepository<Order, String> {
}
@Repository
interface InfoRepository : CrudRepository<OrderInfo, String> {
}
