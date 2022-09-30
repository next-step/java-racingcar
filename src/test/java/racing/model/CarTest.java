package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

	private Car car;

	@BeforeEach
	void before() {
		car = new Car(new Name("name"));
	}

	@DisplayName("자동차는 움직일 수 있다.")
	@Test
	void move() {
		car.move(true);
		assertThat(car.getPosition()).isEqualTo(new Position(1));
	}

	@DisplayName("자동차는 움직이지 않는다.")
	@Test
	void notMove() {
		car.move(false);
		assertThat(car.getPosition()).isEqualTo(new Position(0));
	}
}
