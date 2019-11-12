package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

	@Test
	void move() {
		Car car = new Car();
		assertThat(car.move(true)).isEqualTo(1);
	}
}