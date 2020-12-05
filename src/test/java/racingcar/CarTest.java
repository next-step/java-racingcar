package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("입력값이 4 이상인 경우 moveCount 가 증가해야한다 ")
	void moveTest() {
		Car car = new Car();
		car.tryMove(4);
		assertThat(car.moveCount).isEqualTo(1);
	}

	@Test
	@DisplayName("입력값이 4 미만인 경우 moveCount 가 유지되어야한다 ")
	void stopTest() {
		Car car = new Car();
		car.tryMove(3);
		assertThat(car.moveCount).isEqualTo(0);
	}

	@Test
	@DisplayName("이동이 여러번 시도될 경우 moveCount 는 누적되어 증가해야한다 ")
	void moveRepeatTest() {
		Car car = new Car();
		car.tryMove(4);
		assertThat(car.moveCount).isEqualTo(1);
		car.tryMove(5);
		assertThat(car.moveCount).isEqualTo(2);
		car.tryMove(2);
		assertThat(car.moveCount).isEqualTo(2);
		car.tryMove(9);
		assertThat(car.moveCount).isEqualTo(3);
	}
}
