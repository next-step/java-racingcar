package study.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.racingcar.domain.Car;
import study.racingcar.domain.Position;

public class CarTest {

	@Test
	@DisplayName("자동차 전진")
	void goCar(){
		//given
		boolean isMoveCar = true;

		//when
		Car car = new Car();
		car.go(isMoveCar);
		Position position = car.carPosition();

		//then
		assertThat(position.valueOfPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("자동차 정지")
	void stopCar(){
		//given
		boolean isMoveCar = false;

		//when
		Car car = new Car();
		car.go(isMoveCar);
		Position position = car.carPosition();

		//then
		assertThat(position.valueOfPosition()).isEqualTo(0);
	}

}
