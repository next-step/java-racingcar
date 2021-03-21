package im.juniq.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {
	@DisplayName("위치 생성")
	@Test
	void createPosition() {
		assertThatCode(Position::new).doesNotThrowAnyException();
	}

	@DisplayName("위치 증가")
	@Test
	void increasePosition() {
		Position position = new Position();

		position.increase();

		assertThat(position.value()).isEqualTo(1);
	}
}