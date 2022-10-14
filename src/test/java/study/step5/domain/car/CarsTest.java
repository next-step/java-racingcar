package study.step5.domain.car;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private Cars cars;

	@BeforeEach
	void setUp() {
		cars = new Cars(Arrays.asList(new Car("car1"), new Car("car2")));
	}

	@DisplayName("같은 위치값을 갖는 car를 반환한다.")
	@Test
	void Given_Cars_Then_ReturnMaxPosition() {
		int result = cars.getAllByPosition(0).size();

		assertThat(result).isEqualTo(cars.size());
	}
}