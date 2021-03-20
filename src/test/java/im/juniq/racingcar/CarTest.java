package im.juniq.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import im.juniq.racingcar.domain.Car;
import im.juniq.racingcar.domain.OnlyTrueMovingStrategy;
import im.juniq.racingcar.domain.RandomNumberMovingStrategy;

class CarTest {
	@DisplayName("자동차를 생성한다")
	@ParameterizedTest
	@ValueSource(strings = {"pobi"})
	void createCar(String carName) {
		assertThatCode(() -> new Car(carName, new RandomNumberMovingStrategy())).doesNotThrowAnyException();
	}

	@DisplayName("자동차를 이동한다")
	@ParameterizedTest
	@ValueSource(strings = {"pobi"})
	void moveCar(String carName) {
		OnlyTrueMovingStrategy movingStrategy = new OnlyTrueMovingStrategy();
		Car car = new Car(carName, movingStrategy);

		car.move();

		assertThat(car).isEqualToComparingFieldByFieldRecursively(
			new Car(carName, 1, movingStrategy));
	}
}
