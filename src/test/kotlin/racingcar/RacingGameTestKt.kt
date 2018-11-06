package racingcar

import org.junit.Before
import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

class RacingGameTestKt {
    private lateinit var racingGame: RacingGameKt
    private var carPositions = intArrayOf(0, 0, 0)

    @Before
    fun setup() {
        racingGame = RacingGameKt()
    }

    @Test
    fun 이동범위체크_0_to_3() {
        carPositions = racingGame.move()
        carPositions = racingGame.move()
        carPositions = racingGame.move()
        assertThat(carPositions[0]).isIn(0, 1, 2, 3)
        assertThat(carPositions[1]).isIn(0, 1, 2, 3)
        assertThat(carPositions[2]).isIn(0, 1, 2, 3)
    }

    @Test
    fun 랜덤값_범위체크_0_to_9() {
        val random = racingGame.getRandom()
        val isRange = random in 0..9
        assertThat(isRange).isTrue()
    }

    @Test
    fun 전진_가능한_조건이라면_한칸_이동() {
        val carPositions = intArrayOf(0, 0, 0)
        if (racingGame.isCanMove()) {
            carPositions[0] = carPositions[0] + 1
        }

        assertThat(carPositions[0]).isIn(0, 1)
    }

    @Test
    fun 한칸_이동_테스트() {
        racingGame.moveOnePosition(0, true)
        val carPositions = racingGame.getCarPositions()
        assertThat(carPositions[0]).isEqualTo(1)
    }
}
