package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	@DisplayName("차는 4 이상이면 전진한다")
	void move_on_number_over_4() {
		NumberStrategy numberStrategy = new FixedNumber(4);
		Car notMovedCar = new Car(numberStrategy);
		Car car = new Car(numberStrategy);
		car.move();

		assertThat(car).isNotEqualByComparingTo(notMovedCar);
	}

	@Test
	@DisplayName("차는 4 미만이면 멈춰있는다")
	void stay_on_number_over_4() {
		NumberStrategy numberStrategy = new FixedNumber(3);
		Car notMovedCar = new Car(numberStrategy);
		Car car = new Car(numberStrategy);
		car.move();

		assertThat(car).isEqualByComparingTo(notMovedCar);
	}
}
