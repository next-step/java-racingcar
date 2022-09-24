package carRacing.level3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import carRacing.level3.service.CarService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarServiceTest {

	public static final Integer CAR_NUM = 1;
	public static final Integer MOVE_STATUS = 1;

	CarService carService = new CarService();

	@Test
	@DisplayName("경주가 시작되면 자동차는 랜덤값에 따라 이동한다.")
	public void moveCar() {
		carService.initRace(CAR_NUM);
		int current_status = carService.carStatus(CAR_NUM);

		carService.moveCar(CAR_NUM);
		int new_status = carService.carStatus(CAR_NUM);

		assertEquals(current_status + MOVE_STATUS, new_status);

	}

}
