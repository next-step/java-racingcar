package racingcar.domain

import org.junit.Before
import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

class CarKtTest {
    private lateinit var car: CarKt

    @Before
    fun setup() {
        car = CarKt("테스트차1")
    }

    @Test
    fun `전진 가능한 경우 테스트`() {
        val randomNumber = 4
        car.move(randomNumber)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `전진 불가능한 경우 테스트`() {
        val randomNumber = 3
        car.move(randomNumber)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `세칸 이동 테스트`() {
        val randomNumber = 4
        car.move(randomNumber)
        car.move(randomNumber)
        car.move(randomNumber)
        assertThat(car.position).isEqualTo(3)
    }
}