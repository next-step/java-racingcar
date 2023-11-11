package carRacing.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

	@DisplayName("5자 이상의 이름은 예외를 발생한다.")
	@Test
	void nameLengthException() {
		assertThatThrownBy(() -> {
			new Name("5five");
		}).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("이름이 5자를 초과했습니다.");
	}
}