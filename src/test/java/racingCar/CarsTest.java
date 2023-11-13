package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class CarListTest {

	@T	est
	@DisplayName("addCar_input carCount_size carCount")
	void addCar() {
		Cars carList = new Cars(new ArrayList<>());
		carList.addCar(3);
		assertThat(carList.carList()).hasSize(3);
	}

	@Test
	@DisplayName("moveByTryCount_input tryCount_각 Car의 distance 값이 tryCount 이하")
	void moveByTryCount() {
		Cars carList = new Cars(new ArrayList<>());
		carList.addCar(3);
		carList.moveByTryCount(5);

		for (Car car : carList.carList()) {
			assertThat(car.distance).isLessThan(6);
		}
	}
}