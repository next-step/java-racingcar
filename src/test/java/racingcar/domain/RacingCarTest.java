package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static racingcar.domain.Car.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
	// 자동차 개수
	// 시도 횟수
	List<Car> carList = new ArrayList<Car>();
	Random random = new Random();

	@Test
	@DisplayName("전진하는 경우")
	void moveForward() {
		Car car = new Car("name", 0);
		int randomNum = random.nextInt(10);
		car.moveStrategy(randomNum);
		if (randomNum >= MIN_THRESHOLD)
			assertThat(car.position()).isEqualTo(new Position(1));
	}

	@Test
	@DisplayName("전진하지 않는 경우")
	void notMoveForward() {
		Car car = new Car("name",0);
		int randomNum = random.nextInt(10);
		car.moveStrategy(randomNum);
		if (randomNum < MIN_THRESHOLD)
			assertThat(car.position()).isEqualTo(new Position(0));
	}

	@Test
	@DisplayName("여러 번 시도하는 경우")
	void MoveForward_여러번() {
		for (int i = 0; i < 3; i++) {
			Name name = new Name("name"+i);
			Car car = new Car(name, new Position());
			carList.add(car);
		}
		int randomNum = 0;
		for (int i = 0; i < 2; i++) {
			for (Car car : carList) {
				car.moveStrategy(randomNum++);
			}
		}
		assertThat(carList.get(0).position()).isEqualTo(new Position(0));
		assertThat(carList.get(1).position()).isEqualTo(new Position(1));
		assertThat(carList.get(2).position()).isEqualTo(new Position(1));
	}

	@Test
	void 자동차_이름_구분() {
		String carNames = "car1,car2,car3";
		RacingCars racingCars = new RacingCars(carNames);
		List<String> CarNameList = Arrays.asList("car1", "car2", "car3");
		List<Car> cars = racingCars.cars;
		assertThat(cars.get(0).name()).isEqualTo(new Name(CarNameList.get(0)));
		assertThat(cars.get(1).name()).isEqualTo(new Name(CarNameList.get(1)));
	}
}
