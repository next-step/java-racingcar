package study.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {
	@Test
	@DisplayName("위치 생성")
	void create() {
		//given
		int givenPosition = 10;
		//when
		Position position = new Position(givenPosition);

		//then
		assertThat(position).isEqualTo(new Position(10));
	}

	@Test
	@DisplayName("위치 전진 값 비교")
	void comparePosition() {
		Position position = new Position();
		assertThat(position.move()).isEqualTo(new Position(1));
	}
}