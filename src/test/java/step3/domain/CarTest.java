package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

	private Car car;

	@BeforeEach
	void before() {
		car = new Car("aaa");
	}

	@Test
	void move() {
		assertThat(car.move(true)).isEqualTo(1);
	}

}
