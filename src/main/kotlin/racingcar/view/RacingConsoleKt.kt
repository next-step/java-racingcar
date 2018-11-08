package racingcar.view

import racingcar.RacingGameKt
import racingcar.RacingResultKt

class RacingConsoleKtKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val racingGame = RacingGameKt()

            val carNames = InputViewKt.getInputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
            val playTime = InputViewKt.getInputNumber("시도할 회수는 몇회인가요?")

            racingGame.readyCars(carNames)

            for (i in 0 until playTime) {
                val cars = racingGame.startRacing()

                ResultViewKt.showResult(cars)

                println()
            }

            val racingResult = RacingResultKt(racingGame.getCars())
            ResultViewKt.showWinners(racingResult.getWinners())
        }
    }
}