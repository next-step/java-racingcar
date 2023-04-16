package carRacing.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRacingTest {

	@DisplayName("우승자를 만든다.")
	@Test
	void test1() {
		CarRacing carRacing = new CarRacing();
		Cars cars = carRacing.getCars();
		cars.addCar("pobi", 5);
		cars.addCar("crong", 5);
		cars.addCar("honux", 3);

		assertThat(carRacing.findWinners()).containsExactly(new Car("pobi", 5), new Car("crong", 5));
	}
}
