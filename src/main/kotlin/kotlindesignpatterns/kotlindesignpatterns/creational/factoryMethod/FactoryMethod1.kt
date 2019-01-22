package kotlindesignpatterns.kotlindesignpatterns.creational.factoryMethod

import java.lang.RuntimeException
import java.math.BigDecimal

interface DeliveryType {
    fun calculate(value: BigDecimal): BigDecimal
}

class TruckDelivery : DeliveryType {
    override fun calculate(value: BigDecimal): BigDecimal = value.times(0.2.toBigDecimal())
}

class ShippDelivery : DeliveryType {
    override fun calculate(value: BigDecimal): BigDecimal = value.times(0.1.toBigDecimal())
}

fun main(args: Array<String>) {
    val typeOfDelivery = "truck"

    val deliveryType = when(typeOfDelivery) {
        "truck" -> TruckDelivery()
        "shipp" -> ShippDelivery()
        else -> throw RuntimeException("No delivery method provided")
    }

    val deliveryInitialPrice = 100.toBigDecimal()
    val additionalValue = deliveryType.calculate(deliveryInitialPrice)
    val totalDeliveryPrice = deliveryInitialPrice.plus(additionalValue)

    println("Total value: $totalDeliveryPrice")
}
