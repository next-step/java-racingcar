package carRacing.level3;

import carRacing.level3.domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
	public static final Integer DEFAULT_LOCATION = 1;

	@Test
	void 자동차_한대_생성() {
		Car car = new Car();
		Assertions.assertEquals(car.carLocation(), DEFAULT_LOCATION);
	}

	@Test
	void 자동차_전진() {
		Car car = new Car();
		car.moveLocation();
		Assertions.assertEquals(car.carLocation(), DEFAULT_LOCATION + 1);
	}

}
