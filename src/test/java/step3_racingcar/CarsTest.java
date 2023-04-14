package step3_racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import step3_racingcar.domain.Cars;

public class CarsTest {
	@Test
	void testCarsCreation() {
		int carCount = 5;
		Cars cars = new Cars(carCount);
		assertEquals(carCount, cars.getCars().size());
	}
}
