package step5_racingcar_refactoring;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step5_racingcar_refactoring.domain.Car;
import step5_racingcar_refactoring.service.RandomNumber;

public class CarTest {
	private static final String carName = "test";

	@DisplayName("자동차 생성 실패 테스트")
	@Test
	public void moveTest() {
		String errorCarName = "exceptionCarName";
		Class expect = RuntimeException.class;

		assertThatThrownBy(() -> new Car(errorCarName, 0 , new RandomNumber()))
			.isInstanceOf(expect);
	}

	@DisplayName("자동차 전진")
	@Test
	void movableIsTrue() {
		Car car = new Car(carName, 0, bound -> 5);
		int initialStatus = car.getPosition();

		car.tryMove();

		assertThat(car.getPosition()).isEqualTo(initialStatus + 1);
	}

	@DisplayName("자동차 정지")
	@Test
	void movableIsFalse() {
		Car car = new Car(carName, 0, bound -> 2);
		int initialStatus = car.getPosition();

		car.tryMove();

		assertThat(car.getPosition()).isEqualTo(initialStatus);
	}

}
