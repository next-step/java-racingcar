package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	RandomNumber randomNumber = new RandomNumber();
	Car car = new Car(randomNumber);

	@DisplayName("move() 테스트")
	@Test
	void move() {
		int preCarLocation = car.getLocation();
		int moveDistance = car.move();
		Assertions.assertThat(car.getLocation()).isEqualTo(preCarLocation + moveDistance);
	}
}
