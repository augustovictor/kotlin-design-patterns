package kotlindesignpatterns.kotlindesignpatterns.creational.factoryMethod

interface Transport {
    fun deliver()
}

abstract class Logistics {
    fun planDelivery() {
        val transport = createTransport()
        transport.deliver()
    }

    abstract fun createTransport(): Transport
}

class RoadLogistics : Logistics(), Transport {
    override fun createTransport(): Transport = RoadLogistics()

    override fun deliver() {
        println("Deliverying by road")
    }
}

fun main(args: Array<String>) {
    // Violates: SRP, OCP, DI, SLAP
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
