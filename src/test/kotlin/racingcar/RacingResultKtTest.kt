package racingcar

import org.junit.Before
import org.junit.Test
import racingcar.domain.CarKt

import org.assertj.core.api.Assertions.assertThat

class RacingResultKtTest {
    private lateinit var racingResult: RacingResultKt

    @Before
    fun setup() {
        racingResult = RacingResultKt(getDummyCars())
    }

    @Test
    fun 우승자_판별_테스트() {
        val winners = racingResult.getWinners()
        assertThat(winners).isEqualTo("벤츠,마티즈")
    }

    @Test
    fun 우승_포지션값_구하기() {
        val winnerPosition = racingResult.getWinnerPosition()
        assertThat(winnerPosition).isEqualTo(10)
    }

    private fun getDummyCars(): MutableList<CarKt> {
        return arrayListOf(
                CarKt("붕붕카", 5),
                CarKt("씽씽카", 2),
                CarKt("벤츠", 10),
                CarKt("마티즈", 10)
        )
    }
}
