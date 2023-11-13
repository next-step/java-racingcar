package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

	@Test
	@DisplayName("자동차가 전진한다")
	void 자동차_전진() {
		Position position = new Position(1);

		position.move();

		assertThat(position.current()).isEqualTo(2);
	}
}