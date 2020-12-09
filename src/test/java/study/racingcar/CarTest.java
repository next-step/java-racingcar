package study.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
	Car car;

	@BeforeEach
	void setUp() {
		car = new Car();
	}

	@Test
	void advanced_test() throws Exception {
		int bfPos = car.getPosition();
		car.advanced();

		int position = car.getPosition();

		assertThat(bfPos + 1).isEqualTo(position);
	}
}
