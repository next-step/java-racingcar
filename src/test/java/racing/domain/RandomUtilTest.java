package racing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomUtilTest {

	@ParameterizedTest
	@DisplayName("랜덤값을 입력되면 그값을 반환한다.")
	@CsvSource(value = {"1,2,3,4,5,6,7,8,9"})
	public void randomReturnValue(int inputValue) {
		RandomUtil randomUtil = (randomValue) -> inputValue;

		assertThat(randomUtil.randomGenerate(inputValue)).isEqualTo(inputValue);
	}

}