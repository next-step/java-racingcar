package racingcar

import racingcar.domain.CarKt
import racingcar.view.ResultView
import racingcar.view.ResultViewKt

class RacingGameKt {
    private var cars: MutableList<CarKt> = mutableListOf()
    private var randomProvider: RandomProviderKt = RandomProviderKt()

    fun readyCars(carNames: String) {
        cars = carNames.split(",")
                .map { CarKt(it) }
                .toMutableList()
    }

    fun startRacing(): MutableList<CarKt> {
        cars.forEach {
            it.move(randomProvider.getRandom())
        }

        return cars
    }

    fun showWinner() {
        val racingResult = RacingResultKt(cars)
        ResultView.showWinners(racingResult.getWinners())
    }

    fun getCars(): MutableList<CarKt> = cars
}
