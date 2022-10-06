package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Position;

public class PositionTest {
	@Test
	@DisplayName("포지션 위치 확인")
	void create() {
		Position position = new Position(3);
		assertThat(position).isEqualTo(new Position(3));
	}

	@Test
	@DisplayName("포지션 전진")
	void changePosition() {
		Position position = new Position(1);
		assertThat(position.increase()).isEqualTo(new Position(2));
	}
}
