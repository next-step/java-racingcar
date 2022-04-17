package racingcar.domain;

import org.junit.jupiter.api.Test;

class CarsTest {
	@Test
	public void playTest() {
		Cars cars = Cars.of(3);

		cars.play(() -> 1);
	}
}