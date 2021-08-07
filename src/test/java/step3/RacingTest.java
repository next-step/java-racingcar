package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.domain.Racing;
import step3.domain.RacingResults;

public class RacingTest {
	@DisplayName("레이싱 동작 테스트")
	@CsvSource(value = {"3,A,B,C", "2,A,B,C", "5,A,B,C"})
	@ParameterizedTest
	void race(int numberOfTrials, String carA, String carB, String carC) {
		String[] cars = {carA, carB, carC};
		Racing racing = new Racing(numberOfTrials, cars);
		List<RacingResults> results = racing.race();

		int resultTrials = results.size();
		int resultCars = results.get(0).getResults().size();

		assertThat(resultTrials).isEqualTo(numberOfTrials);
		assertThat(resultCars).isEqualTo(cars.length);
	}
}
