package racingcar.view

import racingcar.RacingGameKt

class RacingConsoleKtKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputView = InputViewKt()
            val racingGame = RacingGameKt()

            val carNames = inputView.getInputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
            val playTime = inputView.getInputNumber("시도할 회수는 몇회인가요?")

            racingGame.readyCars(carNames)
            racingGame.playRacingGame(playTime)
            racingGame.showWinner()
        }
    }
}