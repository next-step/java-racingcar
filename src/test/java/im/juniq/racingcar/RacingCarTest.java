package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {
	@DisplayName("자동차를 생성한다")
	@Test
	void createRacingCar() {
		RacingCar racingCar = new RacingCar(1);

		assertThat(racingCar.getId()).isEqualTo(1);
		assertThat(racingCar.getMoveCount()).isEqualTo(0);
	}

	@DisplayName("자동차를 이동한다")
	@Test
	void moveRacingCar() {
		RacingCar racingCar = new RacingCar(1, new Random() {
			@Override
			public int nextInt(int bound) {
				return 5;
			}
		});
		racingCar.move();

		assertThat(racingCar.getMoveCount()).isEqualTo(1);
	}
}