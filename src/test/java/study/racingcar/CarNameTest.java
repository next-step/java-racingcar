package study.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.racingcar.domain.Name;

public class CarNameTest {

	@Test
	@DisplayName("이름 만들기 - 5자를 초과할 수 없다.")
	void createName() {
		String inputName = "abcdef";
		Name name = new Name(inputName);
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(name::checkLength)
			.withMessageContaining("자동차의 이름은");
	}

}
