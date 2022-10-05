package study.step4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
	private Cars cars;

	@BeforeEach
	void setUp() {
		cars = new Cars();

		Car car1 = new Car();
		car1.initPosition();
		cars.add(car1);

		Car car2 = new Car();
		car2.initPosition();
		cars.add(car2);
	}

	@DisplayName("위치에 해당하는 자동차를 반환한다.")
	@Test
	void Given_Cars_Then_ReturnCarsByPosition() {
		Cars result = cars.getAllByPosition(0);
		assertThat(result.size()).isEqualTo(cars.size());
	}

	@DisplayName("위치의 최대값을 반환한다.")
	@Test
	void Given_Cars_Then_ReturnMaxPosition() {
		int result = cars.findMaxPosition();
		assertThat(result).isEqualTo(0);
	}
}