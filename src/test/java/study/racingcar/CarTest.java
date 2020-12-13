package study.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

	@BeforeEach
	void setUp() {

	}

	@ParameterizedTest
	@CsvSource(value = {"2, 0", "3, 0", "4, 1", "5, 1"})
	void move_test(int randomNo, int result) throws Exception {
		Car car = new Car();

		car.move(randomNo);

		int position = car.getPosition();

		assertThat(result).isEqualTo(position);
	}

	@Test
	void advanced_test() throws Exception {
		Car car = new Car();

		int bfPos = car.getPosition();
		car.advanced();

		int position = car.getPosition();

		assertThat(bfPos + 1).isEqualTo(position);
	}

}
