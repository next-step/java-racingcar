package refactoring.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import strategy.ManualMoveable;

class CarsTest {

	private Cars cars;

	@BeforeEach
	void init() {
		cars = Cars.of("test1,test2,test3");
	}

	@ParameterizedTest
	@CsvSource(value = {"0=false", "1=true", "2=false"}, delimiter = '=')
	@DisplayName("자동차들 움직이기 테스트")
	void moveCars(int input, boolean expected) {
		cars.move(new ManualMoveable());

		List<Car> carRecourds = cars.ofRecord()
									.getRecords();

		for (Car car : carRecourds) {
			assertThat(car.getCarDistance() == input).isEqualTo(expected);
		}
	}
}