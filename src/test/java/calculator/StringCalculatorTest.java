package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {
	@Test
	public void 숫자_하나() {
		int given = StringCalculator.calculate("3");

		assertThat(given).isEqualTo(3);
	}

	@Test
	public void 두수의_합() {
		int given = StringCalculator.calculate("1,2");

		assertThat(given).isEqualTo(3);
	}

	@Test
	public void 구분자_혼용() {
		int given = StringCalculator.calculate("1,2:3");

		assertThat(given).isEqualTo(6);
	}


	@Test
	public void 커스텀_구분자() {
		int given = StringCalculator.calculate("//;\n1;2,3");

		assertThat(given).isEqualTo(6);
	}

	@ParameterizedTest(name = "인자가 {arguments} 일 때, StringCalculator 의 calculate 메서드를 테스트")
	@CsvSource(value = {
		"''",
		"NULL"
	}, nullValues = "NULL")
	public void 빈문자열_또는_null_입력_처리(String input) {
		int given = StringCalculator.calculate(input);
		assertThat(given).isEqualTo(0);
	}

	@Test
	public void 음수_예외처리() {
		assertThatThrownBy(() -> StringCalculator.calculate("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}

}
