package racing.car.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	@DisplayName("우승자 찾기.")
	@Test
	void test1() {
		Cars cars = new Cars();
		cars.addCar("pobi", 5);
		cars.addCar("crong", 10);
		cars.addCar("honux", 10);

		assertThat(cars.findWinners())
			.containsExactly(new Car("crong", 10), new Car("honux", 10));
	}

	@DisplayName("최고 위치 추출.")
	@Test
	void test2() {
		Cars cars = new Cars();
		cars.addCar("pobi", 5);
		cars.addCar("crong", 0);
		cars.addCar("honux", 10);

		assertThat(cars.extractBestLocation()).isEqualTo(new Location(10));
	}
}
