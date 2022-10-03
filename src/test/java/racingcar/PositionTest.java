package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PositionTest {
	@Test
	void create() {
		Position position = new Position(3);
		assertThat(position).isEqualTo(new Position(3));
	}
}
