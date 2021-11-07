package calcuator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperationTest {
	@DisplayName("token 을 사칙연산 으로 변환 검증")
	@ParameterizedTest(name = "{index}. {0} => {1}")
	@MethodSource("provideTokenWithExpectedOperation")
	void convert(String token, Operation expectedOperation) {
		Operation operation = Operation.convert(token);
		assertThat(operation).isEqualTo(expectedOperation);
	}

	@DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException")
	@ParameterizedTest(name = "{index}. invalidToken : {0}")
	@ValueSource(strings = {"!", "@", "#", "$"})
	void convertInvalidToken(String invalidToken) {
		assertThatIllegalArgumentException().isThrownBy(() -> Operation.convert(invalidToken));
	}

	static Stream<Arguments> provideTokenWithExpectedOperation() {
		return Stream.of(
			arguments("+", Operation.PLUS),
			arguments("-", Operation.MINUS),
			arguments("/", Operation.DIVIDE),
			arguments("*", Operation.MULTIPLY)
		);
	}
}
