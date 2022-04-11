package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("음이 아닌 수 객체 테스트")
class NonNegativeTest {

	@Test
	void 문자열_타입의_숫자_입력하는_경우_해당_값을_갖는_객체_생성(){
		assertThat(new NonNegative("1").toResult()).isEqualTo(1);
	}

	@Test
	void 원시_정수형_타입의_숫자_입력하는_경우_해당_값을_갖는_객체_생성(){
		assertThat(new NonNegative(2).toResult()).isEqualTo(2);
	}

	@ParameterizedTest(name = "[{displayName}] input: {0}")
	@NullAndEmptySource
	void null_혹은_빈_문자열을_입력으로_객체_생성하는_경우_예외_반환(String text) {
		assertThatThrownBy(() -> new NonNegative(text))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 문자열_타입의_숫자가_아닌_깂을_입력으로_객체_생성하는_경우_예외() {
		assertThatThrownBy(() -> new NonNegative("가나다"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 문자열_타입의_음수_값을_입력으로_객체_생성하는_경우_예외() {
		assertThatThrownBy(() -> new NonNegative("-1"))
			.isInstanceOf(RuntimeException.class);
	}

	@Test
	void 음이_아닌_수_간의_add_연산을_하는_경우_각각의_값을_더한_새로운_객체가_생성(){
		NonNegative operand1 = new NonNegative("1");
		NonNegative operand2 = new NonNegative("10");

		NonNegative result = operand1.add(operand2);

		assertThat(result.toResult()).isEqualTo(11);
	}
}