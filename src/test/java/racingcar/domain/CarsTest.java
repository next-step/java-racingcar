package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

	@ParameterizedTest
	@ValueSource(ints = {2, 3, 4})
	@DisplayName("생성된 차의 갯수를 확인한다")
	void getCarsSize(int number) {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			carList.add(new Car());
		}

		Cars cars = new Cars(carList);

		assertThat(cars.count()).isEqualTo(number);
	}

	@Test
	@DisplayName("생성된 차를 꺼내온다")
	 void getCar() {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			carList.add(new Car());
		}

		Cars cars = new Cars(carList);

		assertThat(cars.get(0)).isInstanceOf(Car.class);
	}
}
