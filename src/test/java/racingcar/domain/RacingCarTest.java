package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

public class RacingCarTest {
	// 자동차 개수
	// 시도 횟수
	List<Car> carList = new ArrayList<Car>();
	Random random = new Random();
	private static final int MIN_THRESHOLD = 4;

	@Test
	@DisplayName("전진하는 경우")
	void moveForward() {
		Car car = new Car();
		int randomNum = random.nextInt(10);
		car.moveForward(randomNum);
		if (randomNum >= MIN_THRESHOLD)
			assertThat(car.getMoveInfo()).isEqualTo(1);
	}

	@Test
	@DisplayName("전진하지 않는 경우")
	void notMoveForward() {
		Car car = new Car();
		int randomNum = random.nextInt(10);
		car.moveForward(randomNum);
		if (randomNum < MIN_THRESHOLD)
			assertThat(car.getMoveInfo()).isEqualTo(0);
	}

	@Test
	@DisplayName("여러 번 시도하는 경우")
	void MoveForward_여러번() {
		for (int i = 0; i < 3; i++) {
			Car car = new Car();
			carList.add(car);
		}
		int randomNum = 0;
		for (int i = 0; i < 2; i++) {
			for (Car car : carList) {
				car.moveForward(randomNum++);
			}
		}
		assertThat(carList.get(0).getMoveInfo()).isEqualTo(0);
		assertThat(carList.get(1).getMoveInfo()).isEqualTo(1);
		assertThat(carList.get(2).getMoveInfo()).isEqualTo(1);
	}

}
