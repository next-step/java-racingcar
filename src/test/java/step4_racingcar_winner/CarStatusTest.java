package step4_racingcar_winner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step4_racingcar_winner.domain.Car;
import step4_racingcar_winner.dto.CarDTO;
import step4_racingcar_winner.service.Winner;
import step4_racingcar_winner.view.ResultView;

public class CarStatusTest {

	private ResultView resultView;

	@BeforeEach
	void setUp() {
		resultView = new ResultView();
	}

	
	@DisplayName("status 출력값 테스트")
	@Test
	void formatStatus() {
		String carName = "test";
		int position = 5;
		Car car = new Car(carName, 0 , bound -> 5);

		for(int i = 0; i < position ; i++)
		{
			car.tryMove();
		}

		CarDTO carDTO = new CarDTO(car);
		String expectedStatus = "test : -----";

		String actualStatus = resultView.formatStatus(carDTO);
		assertEquals(expectedStatus, actualStatus);
	}
}

