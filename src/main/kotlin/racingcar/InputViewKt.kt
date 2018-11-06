package racingcar

import java.util.*

class InputViewKt {

    var time: Int = 0
        private set
    lateinit var carPositions: IntArray
        private set

    fun input() {
        val scanner = Scanner(System.`in`)
        println("자동차 대수는 몇 대 인가요?")
        carPositions = IntArray(scanner.nextInt())
        println("시도할 회수는 몇 회 인가요?")
        time = scanner.nextInt()
    }
}
