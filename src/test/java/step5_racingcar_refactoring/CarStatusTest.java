package step5_racingcar_refactoring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step5_racingcar_refactoring.domain.Car;
import step5_racingcar_refactoring.dto.CarDTO;
import step5_racingcar_refactoring.view.ResultView;

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

