package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
	void moveRacingCar() throws NoSuchFieldException, IllegalAccessException {
		RacingCar racingCar = new RacingCar(1);
		setMoveMustBeSuccess(racingCar);

		racingCar.move();

		assertThat(racingCar.getMoveCount()).isEqualTo(1);
	}

	public static void setMoveMustBeSuccess(RacingCar racingCar) throws NoSuchFieldException, IllegalAccessException {
		Field random = racingCar.getClass().getDeclaredField("random");
		random.setAccessible(true);
		random.set(racingCar, new Random() {
			@Override
			public int nextInt(int bound) {
				return 5;
			}
		});
	}
}