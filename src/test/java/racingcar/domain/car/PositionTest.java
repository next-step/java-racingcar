package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PositionTest {

	@Test
	void 자동차의_시작위치는_0이다() {
		Position position = new Position();
		assertThat(position.getPosition()).isEqualTo(0);
	}

	@Test
	void 이동시키면_위치가_1_증가시킨다() {
		Position position = new Position();
		position.go();
		assertThat(position.getPosition()).isEqualTo(1);
	}

	@Test
	void 위치인자를_받으면_해당위치부터_시작한다() {
		Position position = new Position(3);
		assertThat(position.getPosition()).isEqualTo(3);
	}

	@Test
	void 위치는_0이상이어야한다() {
		assertThatThrownBy(() -> new Position(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
