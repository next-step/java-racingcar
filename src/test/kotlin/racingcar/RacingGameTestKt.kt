package racingcar

import org.junit.Before
import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

class RacingGameTestKt {
    private lateinit var racingGame: RacingGameKt

    @Before
    fun setup() {
        racingGame = RacingGameKt()
        racingGame.readyCars("붕붕카,씽씽카,타요카")
    }

    @Test
    fun 차량_데이터_준비확인() {
        val carsSize = racingGame.getCars().size
        assertThat(carsSize).isEqualTo(3)
    }
}
