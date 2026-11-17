package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarsTest {

	@ParameterizedTest
	@CsvSource(
		value = {"4,1", "3,0"}
	)
	void 차3대_횟수1번일때_전진하거나_멈춘다(int number, int expected) {
		Cars cars = new Cars(3);
		cars.play(() -> number);
		assertThat(cars.getPositions()).containsOnly(expected);
	}

}
