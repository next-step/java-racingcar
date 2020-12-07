package study.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputScannerTest {

	@Test
	@DisplayName("사용자 입력 성공 테스트")
	public void input_validation_success_test() {
		InputScanner scanner = new InputScanner();
		String input = "1 + 3";

		scanner.validateInput(input);

	}

	@Test
	@DisplayName("사용자 입력 값이 empty인 경우 실패 테스트")
	public void input_validation_empty_input_fail_test() {
		InputScanner scanner = new InputScanner();
		String input = "";

		assertThatThrownBy(() -> {
			scanner.validateInput(input);

		}).isInstanceOf(IllegalArgumentException.class);

	}

	@Test
	@DisplayName("사용자 입력 값이 null인 경우 실패 테스트")
	public void input_validation_null_input_fail_test() {
		InputScanner scanner = new InputScanner();
		String input = null;

		assertThatThrownBy(() -> {
			scanner.validateInput(input);

		}).isInstanceOf(IllegalArgumentException.class);

	}

}
