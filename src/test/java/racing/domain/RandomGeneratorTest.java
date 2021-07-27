package racing.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomGeneratorTest {

	@Test
	@DisplayName("랜덤값은 0이상 10미만의 값을 반환한다.")
	public void randomValueCheck() {
		RandomGenerator randomGenerator = new RandomGenerator();

		int result = randomGenerator.randomGenerate(10);

		assertThat(result).isGreaterThanOrEqualTo(0).isLessThan(10);
	}

	@ParameterizedTest
	@DisplayName("입력된 랜덤값은 0~9사이가 아니면  예외가 발생된다.")
	@CsvSource(value = {"10,11,12,13,14,-1,-4"})
	public void randomValueCheck(int randomValue) {
		RandomGenerator randomGenerator = new RandomGenerator();

		assertThrows(IllegalArgumentException.class, () ->
			randomGenerator.validRandomRangeCheck(randomValue)
		);
	}
}