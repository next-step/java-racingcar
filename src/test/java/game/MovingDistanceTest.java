package game;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MovingDistanceTest {

	@Test
	@DisplayName("이동 거리가 0에서 9사이의 수를 받는가")
	void isRight_MovingDistance0Between9() {
		MovingDistance movingDistance = new MovingDistance(8);
		assertThat(movingDistance.getDistance()).isLessThanOrEqualTo(9);
		assertThat(movingDistance.getDistance()).isGreaterThanOrEqualTo(0);
	}

	@Test
	@DisplayName("이동 거리를 10을 받으면 에러가 발생하는가?")
	void isException_whenGetMovingDistance10() {
		assertThatThrownBy(() -> {
			MovingDistance movingDistance = new MovingDistance(10);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("0에서 9사이 숫자만 입력이 가능");
	}
}