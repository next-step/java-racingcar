package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberTest {

	@RepeatedTest(100)
	@DisplayName("범위 내의 난수를 생성한다")
	void generate_random_number_in_boundary() {
		NumberStrategy randomNumber = new RandomNumber(9);
		int generatedNumber = randomNumber.generate();

		assertThat(generatedNumber).isBetween(0, 9);
	}
}
