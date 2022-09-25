package racing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@DisplayName("자동차는 random 값이 4이상일 때 움직인다.")
	@Test
	void move() {
		Car car = new Car();
		car.move(4);
		Assertions.assertThat(car.getPosition()).isEqualTo(1);
	}

	@DisplayName("자동차는 random 값이 3이하일 때 움직이지 않는다.")
	@Test
	void not_move() {
		Car car = new Car();
		car.move(3);
		Assertions.assertThat(car.getPosition()).isEqualTo(0);
	}
}
