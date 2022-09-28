package racing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PositionTest {

	@DisplayName("자동차 위치를 생성한다.")
	@Test
	void createPosition() {
		Position position = new Position(3);
		Assertions.assertThat(position).isEqualTo(new Position(3));

	}

	@DisplayName("자동차 위치가 음수이면 예외를 반환한다.")
	@Test
	void positionException() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				new Position(-1);
			});
	}
}
