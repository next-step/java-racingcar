package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
	@DisplayName("자동차를 생성한다")
	@Test
	void createCar() {
		Car car = new Car(1);

		assertThat(car.getId()).isEqualTo(1);
		assertThat(car.getMoveCount()).isEqualTo(0);
	}

	@DisplayName("자동차를 이동한다")
	@Test
	void moveCar() {
		Car car = new Car(1);

		car.move(new RandomNumberOnlyNine());

		assertThat(car.getMoveCount()).isEqualTo(1);
	}
}
