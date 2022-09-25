package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racing.model.Car;

class CarTest {

	@Test
	void move() {
		Car car = new Car();
		Assertions.assertThat(car.move()).isEqualTo(1);
	}
}
