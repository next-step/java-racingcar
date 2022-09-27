package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

	@DisplayName("자동차는 움직일 수 있다.")
	@Test
	void move() {
		Car car = new Car();
		car.move(true);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@DisplayName("자동차는 움직이지 않는다.")
	@Test
	void notMove() {
		Car car = new Car();
		car.move(false);
		assertThat(car.getPosition()).isEqualTo(0);
	}
}
