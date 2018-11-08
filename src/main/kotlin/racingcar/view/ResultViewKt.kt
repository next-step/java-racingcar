package racingcar.view

import racingcar.domain.CarKt

object ResultViewKt {
    /**
     * @param cars
     * 결과 출력
     */
    fun showResult(cars: List<CarKt>) {
        cars.forEach {
            drawDash(it)
            println()
        }
    }

    /**
     * @param car
     * 차량 현재 위치를 그린다.
     */
    private fun drawDash(car: CarKt) {
        val sb = StringBuilder().apply {
            append(car.name)
            append(" : ")
        }

        for (j in 0 until car.position) {
            sb.append("-")
        }

        print(sb.toString())
    }

    /**
     * @param winners
     * 우승자 출력
     */
    fun showWinners(winners: String) {
        println(winners + "가 최종 우승했습니다.")
    }
}
