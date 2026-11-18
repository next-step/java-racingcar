package racingcar.car;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
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

	@Test
	void 이름수만큼_자동차를_만든다() {
		List<String> carNames= List.of("pobi", "crong", "honux");
		Cars cars = new Cars(carNames);
		assertThat(cars.getPositions()).hasSize(3);
	}
}
