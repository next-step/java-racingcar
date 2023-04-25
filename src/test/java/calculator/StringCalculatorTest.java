package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringCalculatorTest {
	@Test
	public void 숫자_하나() {
		int actual = StringCalculator.calculate("3");

		assertThat(actual).isEqualTo(3);
	}

	@Test
	public void 두수의_합() {
		int actual = StringCalculator.calculate("1,2");

		assertThat(actual).isEqualTo(3);
	}

	@Test
	public void 구분자_혼용() {
		int actual = StringCalculator.calculate("1,2:3");

		assertThat(actual).isEqualTo(6);
	}


	@Test
	public void 커스텀_구분자() {
		int actual = StringCalculator.calculate("//;\n1;2,3");

		assertThat(actual).isEqualTo(6);
	}

	@ParameterizedTest(name = "인자가 {arguments} 일 때, StringCalculator 의 calculate 메서드를 테스트")
	@NullAndEmptySource
	public void 빈문자열_또는_null_입력_처리(String input) {
		int actual = StringCalculator.calculate(input);

		assertThat(actual).isEqualTo(0);
	}

	@Test
	public void 음수_예외처리() {
		assertThatThrownBy(() -> StringCalculator.calculate("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}

}
