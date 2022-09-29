package carRacing.level3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import carRacing.level3.domain.Car;
import carRacing.level3.service.strategy.RandomMovingStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

	public static final Integer DEFAULT_LOCATION = 0;

	@Test
	void 자동차_한대_생성() {
		Car car = new Car();
		assertEquals(car.carLocation(), DEFAULT_LOCATION);
	}

	@Test
	void 자동차_전진() {
		Car car = new Car();
		car.moveLocation(new RandomMovingStrategy());
		assertThat(car.carLocation()).isGreaterThanOrEqualTo(DEFAULT_LOCATION);
	}

}
