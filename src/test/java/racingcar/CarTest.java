package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	void 처음위치는_0이다() {
		Car car = new Car();
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	void 랜덤숫자가_4미만이면_멈춘다() {
		Car car = new Car();
		car.go(3);
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	void 랜덤숫자가_4이상이면_전진한다() {
		Car car = new Car();
		car.go(4);
		assertThat(car.getPosition()).isEqualTo(1);
	}
}
