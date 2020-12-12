package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import step3.utils.Message;

public class PositionTest {
	@Test
	void constructorTest() {
		assertThat(new Position(1)).isEqualTo(new Position(1));
	}

	@Test
	void goTest() {
		Position position = new Position(0);
		position.go();

		assertThat(position).isEqualTo(new Position(1));
	}
}
