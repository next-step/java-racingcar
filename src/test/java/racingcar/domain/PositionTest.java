package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	void 생성() {
		Position position = new Position(4);
		assertThat(position.getValue()).isEqualTo(4);
	}

	@Test
	void increase() {
		Position position = new Position(4);
		position.moveForward();
		assertThat(position.getValue()).isEqualTo(5);
	}

	@Test
	void isEqual() {
		Position position = new Position(4);
		assertThat(position.isEqual(4)).isTrue();
		assertThat(position.isEqual(5)).isFalse();
	}
}