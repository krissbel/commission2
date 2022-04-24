const val CARD_TYPE: String = "VkPay"
const val SUMM_IN_MONTH: Int = 73_000_000
const val NEW_TRANSFER: Int = 1_000_000

const val CARD_TYPE_2: String = "MasterCard"
const val SUMM_IN_MONTH_2: Int = 73_000_000
const val NEW_TRANSFER_2: Int = 1_000_000

const val CARD_TYPE_3: String = "Maestro"
const val SUMM_IN_MONTH_3: Int = 8_000_000
const val NEW_TRANSFER_3: Int = 1_500_000

const val MAX_SUMM_WITHOUT_COMMISSION: Int = 7_500_000

fun main() {
    println("${commissionCalculation(CARD_TYPE, SUMM_IN_MONTH, NEW_TRANSFER)}")
    println("${commissionCalculation(CARD_TYPE_2, SUMM_IN_MONTH_2, NEW_TRANSFER_2)}")
    println("${commissionCalculation(CARD_TYPE_3, SUMM_IN_MONTH_3, NEW_TRANSFER_3)}")
}

fun commissionCalculation(cardType: String, summInMonth: Int, newTransfer: Int): String {
    val commission: Double = when (cardType) {
        "MasterCard", "Maestro" -> newTransfer / 100 * 0.6 + 20
        else -> 0.0
    }
    return when {
        (summInMonth + newTransfer) > MAX_SUMM_WITHOUT_COMMISSION -> "Зачислено: " + (newTransfer - commission) / 100 + " р. " + "Комиссия составила: " + commission / 100 + " р."
        else -> "Зачислено: " + newTransfer / 100 + " р. " + " Комиссия составила: 0.0 р."
    }
}