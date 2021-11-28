package com.example.retailer.storage

import com.example.retailer.api.distributor.Order
import com.example.retailer.api.distributor.OrderInfo
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


/**
 * Интерфейс для организации хранилища заявок
 */

interface OrderStorage{

    /**
     * Первичное сохранение заявки в БД
     * Нужно вернуть объект с заполненным id
     */
    fun createOrder(draftOrder: Order) : PlaceOrderData

    /**
     * Обновление заявки
     */
    fun updateOrder(order: OrderInfo) : Boolean

    /**
     * Получение информации о заявке по id или null если не найдено
     */
    fun getOrderInfo(id: String) : OrderInfo?

}