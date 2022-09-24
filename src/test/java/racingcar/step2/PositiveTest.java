package racingcar.step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveTest {

	@DisplayName("문자열로 생성된 객체와 숫자로 생성된 객체는 같음")
	@Test
	void createTest() {
		Positive positive = new Positive("1");

		assertThat(positive).isEqualTo(new Positive(1));
	}

	@DisplayName("생성자에 음수를 전달하면 예외 발생")
	@Test
	void createByNegativeTest() {
		assertThatThrownBy(() -> new Positive("-1"))
			.isExactlyInstanceOf(NumberFormatException.class);
	}

	@DisplayName("생성자에 숫자 외의 값을 전달하면 예외 발생")
	@Test
	void createByNotNumberTest() {
		assertThatThrownBy(() -> new Positive("a"))
			.isExactlyInstanceOf(NumberFormatException.class);
	}

	@DisplayName("두 객체를 합할 때 더한 값을 갖는 새로운 객체 반환")
	@Test
	void plusTest() {
		Positive one = new Positive("1");
		Positive two = new Positive("2");

		Positive result = one.plus(two);

		assertThat(result).isEqualTo(new Positive("3"));
	}
}
