package step4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

	Position position;

	@BeforeEach
	void beforeEach(){
		position = new Position(3);
	}

	@Test
	@DisplayName("자동차 움직임의 최대값과 일치하는가?")
	void isEqualToMaxPosition(){
		assertThat(position.isMaxPosition(3)).isTrue();
		assertThat(position.isMaxPosition(2)).isFalse();
	}

	@Test
	@DisplayName("자동차들의 움직임에 대해 최대값 구하기")
	void getMaxPositionVal() {
		assertThat(position.maxPosition(2)).isEqualTo(3);
		assertThat(position.maxPosition(4)).isEqualTo(4);
	}
}