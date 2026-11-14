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
	void 전진하면_1증가한다() {
		Car car = new Car();
		car.go();
		assertThat(car.getPosition()).isEqualTo(1);
	}
}
