package step5.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

	Position position;

	@BeforeEach
	void beforeEach(){
		position = new Position(3);
	}

	@Test
	void 포지션증가_테스트() {
		position.increase();
		assertThat(position.getPosition()).isEqualTo(4);
	}

	@Test
	void 최대포지션값_확인테스트() {
		assertThat(position.maxPosition(1)).isEqualTo(3);
		assertThat(position.maxPosition(4)).isEqualTo(4);
	}

	@Test
	void 포지션값_최대여부_확인테스트() {
		assertThat(position.isSamePosition(5)).isFalse();
		assertThat(position.isSamePosition(3)).isTrue();
	}
}