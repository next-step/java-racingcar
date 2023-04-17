package step4_racingcar_winner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4_racingcar_winner.domain.Car;
import step4_racingcar_winner.dto.CarDTO;
import step4_racingcar_winner.view.ResultView;

public class CarStatusTest {
	
	@DisplayName("status 출력값 테스트")
	@Test
	void formatStatus() {
		String carName = "testCar";
		int position = 5;
		Car car = new Car(carName);

		for(int i = 0; i < position ; i++)
		{
			car.tryMove(true);
		}

		CarDTO carDTO = new CarDTO(car);
		String expectedStatus = "testCar : -----";

		String actualStatus = ResultView.formatStatus(carDTO);
		assertEquals(expectedStatus, actualStatus);
	}
}

