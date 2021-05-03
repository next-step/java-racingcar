package game;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MovingDistanceTest {

	MovingDistance movingDistance;

	@BeforeEach
	void init() {
		movingDistance = new MovingDistance();
	}

	@Test
	@DisplayName("이동 거리가 0에서 9사이의 수를 받는가")
	void isRight_MovingDistance0Between9() {
		movingDistance.move(8);
		assertThat(movingDistance.getDistance()).isLessThanOrEqualTo(9);
		assertThat(movingDistance.getDistance()).isGreaterThanOrEqualTo(0);
	}

	@Test
	@DisplayName("이동 거리를 10을 받으면 에러가 발생하는가?")
	void isException_WhenGetMovingDistance10() {
		assertThatThrownBy(() -> {
			movingDistance.move(10);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("0에서 9사이 숫자만 입력이 가능");
	}

	@Test
	@DisplayName("랜덤 값 4이상을 받을시 이동거리가 올라가는가?")
	void isRight_WhenGetMovingRandomNumberGreatThanOrEqual4Moving() {
		movingDistance.move(9);
		assertThat(movingDistance.getDistance()).isEqualTo(1);
	}

	@Test
	@DisplayName("랜덤 값 3이하를 받을시 이동하지 않는가? ")
	void isRight_WhenGetMovingRandomNumberLessThan4Moving() {
		movingDistance.move(3);
		assertThat(movingDistance.getDistance()).isEqualTo(0);
	}

	@Test
	@DisplayName("이동_했을때_정상적으로_distance_올라가는가? ")
	void 이동_했을때_정상적으로_distance_올라가는가() {
		movingDistance.move(4);
		movingDistance.move(5);
		assertThat(movingDistance.getDistance()).isEqualTo(2);
	}

	@Test
	@DisplayName("이동_했을때_displayDistance가_정상적으로_보이는가?")
	void 이동_했을때_displayDistance가_정상적으로_보이는가() {
		movingDistance.move(4);
		movingDistance.move(5);
		assertThat(movingDistance.displayDistance()).isEqualTo("--");
	}
}