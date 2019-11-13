package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

	private Car car;

	@BeforeEach
	void 전처리() {
		car = new Car("aaa");
		car.setPosition(5);
	}

	@Test
	void 이동하기() {
		assertThat(car.move(true)).isEqualTo(6);
	}

	@Test
	void printCarStatus() {
		assertThat(car.printCarStatus()).isEqualTo(5);
	}
}