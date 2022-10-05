package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Name;

public class NameTest {
	@Test
	@DisplayName("이름 생성")
	void create() {
		Name name = new Name("abcde");
		assertThat(name).isEqualTo(new Name("abcde"));
	}

	@Test
	@DisplayName("5자 초과 예외발생")
	void valid() {
		assertThatThrownBy(() -> new Name("abcdef"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("이름 확인")
	void checkName() {
		Name name = new Name("abcde");
		assertThat(name.getName()).isEqualTo("abcde");
	}
}
