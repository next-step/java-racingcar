package racingcar

import racingcar.domain.CarKt

class RacingResultKt(private val cars: MutableList<CarKt>) {

    fun getWinners(): String =
            cars.filter { it.isWinner(getWinnerPosition()) }
                    .joinToString(",") { it.name }

    fun getWinnerPosition(): Int =
            cars.maxBy { it.position }!!.position

}
