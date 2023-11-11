package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

	@Test
	@DisplayName("move_getDistance_0 <= distance <= 횟수")
	void move_test() {
		Car car = new Car();
		for (int i = 0; i < 5; i++) {
			car.move();
		}
		assertThat(car.distance).isBetween(0, 5);
	}
}
