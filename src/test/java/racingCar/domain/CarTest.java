package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingCar.domain.Car;

public class CarTest {
	private Car car;

	@BeforeEach
	void setUp() {
		car = Car.of();
	}

	@ParameterizedTest(name = "속력이 {arguments} 일 때 {arguments} 마일 만큼 이동한다")
	@ValueSource(ints = { 1, 2, 3, 4, 5 })
	void drive_arguments_mile(int speed) {
		car.accelerate(speed);
		car.drive();

		assertThat(car.getDistanceList()).hasSize(speed);
	}

	@Test
	@DisplayName("자동차가 달리다가 멈췄다면 속도는 0이어야 한다")
	void car_should_stop() {
		car.accelerate();
		car.drive();
		car.stop();

		assertThat(car.getSpeed()).isEqualTo(Car.ZERO);
	}
}
