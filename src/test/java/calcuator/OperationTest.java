package calcuator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperationTest {
	@DisplayName("token 을 사칙연산 으로 변환")
	@ParameterizedTest
	@ValueSource(strings = {"+", "-", "/", "*"})
	void convert(String token) {
		Operation operation = Operation.convert(token);
		assertThat(operation).isNotNull();
	}

	@DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException")
	@ParameterizedTest
	@ValueSource(strings = {"!", "@", "#", "$"})
	void convertInvalidToken(String token) {
		assertThatIllegalArgumentException().isThrownBy(() -> Operation.convert(token));
	}
}