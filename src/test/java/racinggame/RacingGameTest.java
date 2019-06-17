package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.Car;
import racinggame.util.RandomValueUtil;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

	@DisplayName("랜덤함수 테스트")
	@Test
	void getRandomValue() {
		int testSize = 10000;

		for (int i = 0; i < testSize; i++) {
			int randomValue = RandomValueUtil.getRandomValue();
			assertThat(IntStream.rangeClosed(0, 9)
				.anyMatch(r -> r == randomValue))
				.isTrue();
		}
	}

	@DisplayName("자동차 이동 테스트")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 4, 7, 9, 10})
	void move(int movePoint) {
		final Car car = new Car();

		for (int i = 0; i < movePoint; i++) {
			car.move();
		}

		assertThat(car.getStatus()).isEqualTo(movePoint);
	}
}
