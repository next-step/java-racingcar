package carRacing.level3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import carRacing.level3.model.Car;
import carRacing.level3.model.strategy.RandomMovingStrategy;
import org.junit.jupiter.api.Test;

public class CarTest {

	public static final Integer DEFAULT_LOCATION = 0;

	@Test
	void 자동차_한대_생성() {
		Car car = new Car("testCar1");
		assertThat(car).isEqualTo(new Car("testCar1"));
	}

	@Test
	void 자동차_전진() {
		Car car = new Car("testCar1");
		car.moveLocation(new RandomMovingStrategy());
		assertThat(car.carLocation()).isGreaterThanOrEqualTo(DEFAULT_LOCATION);
	}

}
