package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositiveTest {

	@DisplayName("양수만 가질 수 있다")
	@Test
	void positive_integer_only() {
		assertThatThrownBy(() -> new Positive(-1))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("숫자 문자열로 생성할 수 있다")
	@Test
	void constructor_with_string_exists() {
		assertThat(new Positive("7")).isEqualTo(new Positive(7));
	}

	@DisplayName("숫자가 아닌 문자열로는 생성할 수 없다")
	@Test
	void string_constructor_accepts_number_only() {
		assertThatThrownBy(() -> new Positive("a"))
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
