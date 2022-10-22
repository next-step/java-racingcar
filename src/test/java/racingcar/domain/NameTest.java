package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.exception.NameException;

class NameTest {

	@Test
	@DisplayName("이름은 1자 이상이다")
	void name_must_have_length() {
		String name = "";

		assertThatThrownBy(() -> new Name(name)).isInstanceOf(NameException.class);
	}

	@Test
	@DisplayName("이름은 5자 이하이다")
	void name_length_less_or_equal_5() {
		String name = "123456";

		assertThatThrownBy(() -> new Name(name)).isInstanceOf(NameException.class);
	}

	@Test
	@DisplayName("이름은 공백일 수 없다")
	void name_is_not_blank() {
		String name = "    ";

		assertThatThrownBy(() -> new Name(name)).isInstanceOf(NameException.class);
	}

	@Test
	@DisplayName("이름에서 공백이 제거된다")
	void blank_is_trimmed_by_default() {
		String name = "    a";

		assertThat(Name.trimmedFrom(name)).isEqualTo(new Name("a"));
	}
}