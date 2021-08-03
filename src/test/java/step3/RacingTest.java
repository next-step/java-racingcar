package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.domain.Racing;
import step3.domain.RacingResult;

public class RacingTest {
	@DisplayName("레이싱 동작 테스트")
	@CsvSource(value = {"3:5", "2:4", "5:5"}, delimiter = ':')
	@ParameterizedTest
	void race(int numberOfTrials, int numberOfCars) {
		Racing racing = new Racing(numberOfTrials, numberOfCars);
		List<RacingResult> result = racing.race();

		int resultTrials = result.size();
		int resultCars = result.get(0).getPositionOfCars().size();

		assertThat(resultTrials).isEqualTo(numberOfTrials);
		assertThat(resultCars).isEqualTo(numberOfCars);
	}
}
