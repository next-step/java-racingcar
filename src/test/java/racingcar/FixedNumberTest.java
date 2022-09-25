package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FixedNumberTest {

	@Test
	@DisplayName("지정된 숫자를 반환한다")
	void generate_random_number_in_boundary() {
		NumberStrategy fixedNumber = new FixedNumber(9);
		int generatedNumber = fixedNumber.generate();

		assertThat(generatedNumber).isEqualTo(9);
	}
}
