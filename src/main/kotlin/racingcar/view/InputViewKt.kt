package racingcar.view

import java.util.*

object InputViewKt {

    private val scanner: Scanner = Scanner(System.`in`)

    fun getInputString(message: String): String {
        println(message)
        return scanner.next()
    }

    fun getInputNumber(message: String): Int {
        println(message)
        return scanner.nextInt()
    }
}
