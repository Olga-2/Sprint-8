package com.example.retailer.api.distributor

import javax.persistence.Embeddable
import javax.persistence.Entity

/**
 * Описание товара
 */
@Embeddable
data class Item(
    /**
     * Произвольный идентификатор
     */
    val id: Long,

    /**
     * Произвольное название
     */
    val name: String
)