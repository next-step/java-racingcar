package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class OperatorTest {

	@DisplayName("사칙 연산 문자열과 Enum 함수의 이름이 일치하는지 확인한다.")
	@ParameterizedTest
	@CsvSource(value = {"+:ADD", "-:SUBTRACT", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
	void shouldEqualsSymbolCharAndSymbolName(String symbol, String symbolName) {
		assertThat(Operator.valueOf(symbolName).getSymbol()).isEqualTo(symbol);
	}

	@DisplayName("사칙 연산 문자열로 Enum 함수를 찾는다.")
	@ParameterizedTest
	@ValueSource(strings = {"+", "-", "*", "/"})
	void shouldFindStringSymbolFromOperation(String symbol) {
		assertThat(Arrays.stream(Operator.values()).anyMatch(v -> v.getSymbol().equals(symbol))).isTrue();
	}

}
