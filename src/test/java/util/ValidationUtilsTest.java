package util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationUtilsTest {

	@DisplayName("입력 값 공백 검증")
	@ParameterizedTest
	@ValueSource(strings = {""})
	public void isEmptyTest(String inputValue) {
		assertThatThrownBy(() -> {
			ValidationUtils.isEmpty(inputValue);
		}).isInstanceOf(IllegalArgumentException.class)
		  .hasMessageContaining("공백이 입력 되었습니다. 입력 값을 확인해주세요." );
	}
	
	@DisplayName("연산자 검증")
	@ParameterizedTest
	@ValueSource(strings = {"@", "$"})
	public void isOperatorTest(String inputValue) {
		assertThatThrownBy(() -> {
			ValidationUtils.isOperator(inputValue);
		}).isInstanceOf(IllegalArgumentException.class)
		  .hasMessageContaining("연산자가 아닌 기호가 입력되었습니다. 입력 값을 확인해주세요." );
	}
}
