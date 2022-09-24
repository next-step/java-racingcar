package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Deprecated
public class PositiveTest {

	@DisplayName("양수만 가질 수 있다")
	@Test
	void positive_integer_only() {
		assertThatThrownBy(() -> new Positive(-1))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("문자열 생성자는 숫자만 허용한다")
	@Test
	void string_constructor_accepts_number_only() {
		assertThat(Positive.ofString("7")).isEqualTo(new Positive(7));
		assertThatThrownBy(() -> Positive.ofString("1a"))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("서로 더할 수 있다")
	@Test
	void mutual_addable() {
		Positive one = new Positive(1);
		Positive other = new Positive(8);

		assertThat(one.plus(other)).isEqualTo(new Positive(9));
	}
}
