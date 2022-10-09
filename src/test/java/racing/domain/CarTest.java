package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	private static final String TEST_CAR_NAME = "BANGBANG";

	RandomNum randomNumber = new RandomNumTestImpl();
	Car car = new Car(TEST_CAR_NAME, randomNumber);

	@DisplayName("move() 테스트")
	@Test
	void move() {
		int preCarLocation = car.getLocation();
		int moveDistance = car.move();
		Assertions.assertThat(car.getLocation()).isEqualTo(preCarLocation + moveDistance);
	}
}
