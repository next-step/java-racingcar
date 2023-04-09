package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 경주 테스트")
public class CarTest {

	@DisplayName("0~9 사이의 랜덤값을 반환하는지 확인한다.")
	@Test
	void test1() {
		for (int i = 0; i < 1000; i++) {
			assertThat(Car.randomInt()).isBetween(Car.MINIMUM_RANDOM_VALUE, Car.MAXIMUM_RANDOM_VALUE);
		}
	}

	@DisplayName("랜덤값이 4이상이면 전진하고, 4미만이면 멈춘다.")
	@ValueSource(ints = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 })
	@ParameterizedTest
	void test2(int randomValue) {
		Car car = new Car();
		assertThat(car.currentLocation()).isEqualTo(0);
		car.move(randomValue);

		if (randomValue >= Car.MINIMUM_VALUE_TO_FORWARD) {
			assertThat(car.currentLocation()).isEqualTo(Car.MOVE_COUNT);
			return;
		}
		assertThat(car.currentLocation()).isEqualTo(0);
	}
}
