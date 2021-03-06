package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	@DisplayName("입력값 공백 제거 및 숫자/연산자 분리")
	void splitNumberAndOperatorTest() {
		String data = "2 + 3 * 4 / 2";
		String[] splitData = calculator.splitNumberAndOperator(data);

		assertThat(splitData.length).isEqualTo(7);
		assertThat(splitData).containsExactly("2", "+", "3", "*", "4", "/", "2");
	}

	@Test
	@DisplayName("입력값 검증 : 공백 및 Null 체크")
	void validateInputEmptyOrNullTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			calculator.validateInputEmptyOrNull("");
		});

		assertThatIllegalArgumentException().isThrownBy(() -> {
			calculator.validateInputEmptyOrNull(" ");
		});

		assertThatIllegalArgumentException().isThrownBy(() -> {
			calculator.validateInputEmptyOrNull(null);
		});
	}

	@Test
	@DisplayName("입력값 검증 : 사칙 연산 기호 체크")
	void validateInputOperatorTest() {
		String[] data = {"1", "&", "5", "_", "8"};

		assertThatIllegalArgumentException().isThrownBy(() -> {
			calculator.validateInputOperator(data);
		});
	}

}
