package racing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

	@Test
	void 자동차_전진() {
		Position position = new Position(1);

		position.move();

		assertThat(position.current()).isEqualTo(2);
	}
}