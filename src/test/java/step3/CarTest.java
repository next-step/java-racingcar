package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

	private Car car;

	@BeforeEach
	void before() {
		car = new Car("aaa");
		car.setPosition(5);
	}

	@Test
	void move() {
		assertThat(car.move(true)).isEqualTo(6);
	}

	@Test
	void printCarStatus() {
		assertThat(car.printCarStatus()).isEqualTo(5);
	}
}