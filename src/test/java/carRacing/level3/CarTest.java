package carRacing.level3;

import carRacing.level3.domain.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
	public static final Integer DEFAULT_LOCATION = 1;
	public static final Integer TEST_CARNUM = 1;

	@Test
	void 자동차_한대_생성() {
		Car car = new Car(TEST_CARNUM);
		Assertions.assertEquals(car.carLocation(), DEFAULT_LOCATION);
		Assertions.assertEquals(car.carNum(), TEST_CARNUM);
	}

	@Test
	void 자동차_전진() {
		Car car = new Car(TEST_CARNUM);
		car.moveLocation();
		Assertions.assertEquals(car.carLocation(), DEFAULT_LOCATION + 1);
	}

}
