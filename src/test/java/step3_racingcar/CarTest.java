package step3_racingcar;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import step3_racingcar.domain.Car;
import step3_racingcar.domain.Cars;

public class CarTest {
	@Test
	void testMove() {
		Car car = new Car();
		car.tryMove();
		String status = car.getStatus();
		assertTrue(status.length() <= 1);
	}
}



