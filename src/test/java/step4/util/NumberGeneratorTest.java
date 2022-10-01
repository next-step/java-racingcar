package step4.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberGeneratorTest {

	@ParameterizedTest
	@ValueSource(ints = {11, 12, 13})
	@DisplayName("랜덤 숫자 생성기에서 허용되는 범위를 넘기면 Exception 을 발생시킨다.")
	void randomNumberGeneratorBoundExceptionTest(int boundNumber){
		assertThatThrownBy(() -> new RandomNumberGenerator().generateNumber(boundNumber)).isInstanceOf(RuntimeException.class);
	}
}