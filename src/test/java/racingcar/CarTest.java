package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
	@Test
	@DisplayName("Car이 생성된 후 초기 위치는 0이다.")
	void whenCarCreatedThenPositionIs0() {
		Car car = new Car();
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("Car가 움직이면 위치는 증가한다.")
	void whenCarMoveThenPositionIncreases() {
		Car car = new Car();
		car.move();

		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("움직일 수 있는 조건을 만족하면 위치는 증가한다.")
	void increasePositionWithSatisfiedStrategy() {
		Car car = new Car(() -> true);
		car.move();

		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("움직일 수 있는 조건을 만족하지 못하면 움직임은 증가하지 않는다.")
	void notIncreasePositionWithNotSatisfiedStrategy() {
		Car car = new Car(() -> false);
		car.move();

		assertThat(car.getPosition()).isEqualTo(0);
	}
}
