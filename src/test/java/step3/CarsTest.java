package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import step3.domain.Cars;

public class CarsTest {
	@DisplayName(value = "Cars 동작 테스트")
	@ValueSource(ints = {1, 2, 3})
	@ParameterizedTest
	void raceOneTrial(int numberOfCars) {
		Cars cars = new Cars(numberOfCars);
		cars.raceOneTrial();
		List<Integer> results = cars.getResultOneTrial();

		assertThat(results.size()).isEqualTo(numberOfCars);
	}
}
