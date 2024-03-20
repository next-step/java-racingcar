package racingCar;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

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

	@Test
	@DisplayName("전진하는 경우")
	void moveForward() throws Exception {
		Car car = new Car();
		int randomNum = random.nextInt(10);
		car.moveForward(randomNum);
		if (randomNum >= 4)
			assertThat(car.getMoveInfo()).isEqualTo(1);
	}

	@Test
	@DisplayName("전진하지 않는 경우")
	void notMoveForward() throws Exception {
		Car car = new Car();
		int randomNum = random.nextInt(10);
		car.moveForward(randomNum);
		if (randomNum < 4)
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

	@Test
	void 자동차_이름_부여() {
		Car car = new Car("춘봉");
		assertThat(car.getName()).isEqualTo("춘봉");
	}

	@DisplayName("자동차 이름은 5글자를 넘을 수 없다")
	@Test
	void carNamelengthUnder5() {
		assertThrows(IllegalArgumentException.class, () -> new Car("춘봉봉봉봉봉"));
	}

}
