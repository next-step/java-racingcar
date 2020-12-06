package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
	@ParameterizedTest
	@ValueSource(ints = {1, 3, 5, 100})
	@DisplayName("입력된 숫자만큼 Car 리스트 생성되어야 한다")
	void carsCreateTest(int carCount) {
		Cars cars = new Cars(carCount);
		assertThat(cars.sizeOfCars()).isEqualTo(carCount);
	}
}
