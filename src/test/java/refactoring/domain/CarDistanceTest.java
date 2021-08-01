package refactoring.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarDistanceTest {

	private CarDistance carDistance;

	@BeforeEach
	void init() {
		carDistance = new CarDistance();
	}

	@Test
	@DisplayName("이동 후 거리 비교 테스트")
	void increaseDistanceSuccess() {
		carDistance.increaseDistance();

		assertThat(carDistance.getDistance()).isEqualTo(1);
	}

	@Test
	void testEqualsSuccess() {
		CarDistance compareCarDistance = new CarDistance();

		compareCarDistance.increaseDistance();

		assertThat(carDistance.equals(compareCarDistance)).isFalse();
	}
}