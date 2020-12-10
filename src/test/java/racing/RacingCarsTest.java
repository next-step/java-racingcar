package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racing.model.RacingCars;
import racing.view.UserOutput;

public class RacingCarsTest {

	@Test
	@DisplayName("레이싱 복수 객체 주행 출력 테스트")
	void printCarsTest() {

		RacingCars cars = new RacingCars(5);

		for (int i = 0; i < 10; i++) {
			cars.start();
			UserOutput.printCarLocation(cars.getRacingCars());
		}
	}

}
