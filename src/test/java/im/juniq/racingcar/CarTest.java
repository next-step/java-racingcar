package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
	@DisplayName("자동차를 생성한다")
	@Test
	void createRacingCar() {
		Car car = new Car(1);

		assertThat(car.getId()).isEqualTo(1);
		assertThat(car.getMoveCount()).isEqualTo(0);
	}

	@DisplayName("자동차를 이동한다")
	@Test
	void moveRacingCar() throws NoSuchFieldException, IllegalAccessException {
		Car car = new Car(1);
		setMoveMustBeSuccess(car);

		car.move();

		assertThat(car.getMoveCount()).isEqualTo(1);
	}

	public static void setMoveMustBeSuccess(Car car) throws NoSuchFieldException, IllegalAccessException {
		Field random = car.getClass().getDeclaredField("random");
		random.setAccessible(true);
		random.set(car, new Random() {
			@Override
			public int nextInt(int bound) {
				return 5;
			}
		});
	}
}