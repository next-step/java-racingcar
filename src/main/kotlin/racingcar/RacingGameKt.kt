package racingcar

import java.util.*

class RacingGameKt {

    fun move(): IntArray {
        moveCarPositions()
        return carPositions
    }

    /**
     * 입력된 차량 대수만큼 포지션 값을 움직인다.
     */
    fun moveCarPositions() {
        for (position in carPositions.indices) {
            moveOnePosition(position, isCanMove())
        }
    }

    /**
     * @param position
     * 전진 가능한 조건이라면 한칸 이동.
     */
    fun moveOnePosition(position: Int, isCanMove: Boolean) {
        if (isCanMove) {
            carPositions[position] = carPositions[position] + 1
        }
    }

    /**
     * 전진 가능여부 체크.
     */
    fun isCanMove(): Boolean {
        return getRandom() >= MIN_NUM
    }

    /**
     * 0 ~ 9 랜덤한 숫자를 반환.
     */
    fun getRandom(): Int {
        return Random().nextInt(BOUND)
    }

    fun getCarPositions(): IntArray = carPositions

    companion object {
        private const val MIN_NUM = 4
        private const val BOUND = 10
        private var time: Int = 0
        private var carPositions: IntArray = intArrayOf(0, 0, 0)

        @JvmStatic
        fun main(args: Array<String>) {
            val inputView = InputViewKt()
            val racingGame = RacingGameKt()

            // 값 입력
            inputView.input()

            // 입력받은 값 획득
            carPositions = inputView.carPositions
            time = inputView.time

            // 게임 회수만큼 레이싱 시작
            for (i in 0 until time) {
                carPositions = racingGame.move()

                // 게임 회수 마다 전체 결과 출력
                ResultViewKt.showResult(carPositions)

                // 한 회수당 구분을 위한 줄바꿈 처리
                println()
            }
        }
    }
}
