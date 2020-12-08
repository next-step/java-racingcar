package step3.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.racingcar.number.RandomNumberGenerator;

public class RandomNumberTest {

	@DisplayName("0~9 범위의 난수 생성")
	@Test
	void given_random_number_generator_when_generate_then_return_random_value_between_zero_to_nine() {
		int result = RandomNumberGenerator.generate();
		assertThat(result).isBetween(0, 9);
	}

}
