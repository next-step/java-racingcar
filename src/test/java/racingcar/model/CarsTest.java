package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
	@DisplayName("자동차를 생성한다")
	@Test
	void 자동차를_생성한다() {
		Cars cars = new Cars();
		List<String> carNames = Arrays.asList("pobi", "conan");
		cars.createCars(carNames);
		assertThat(cars.car(0).name().equals("pobi")).isTrue();
		assertThat(cars.car(1).name().equals("conan")).isTrue();
	}
}
