package carRacing.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

	@DisplayName("위치가 음수일 때 예외를 던진다")
	@Test
	void negativePositionException() {
		assertThatThrownBy(() -> {
			new Position(-3);
		}).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("위치는 음수일 수 없습니다.");
	}
}