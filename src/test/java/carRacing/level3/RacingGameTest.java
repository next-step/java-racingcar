package carRacing.level3;

import carRacing.level3.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

	RacingGame race = new RacingGame();

	public static final Integer DEFAULT_STATUS = 1;

	CarService carService = new CarService();

	@Test
	@DisplayName("전체 자동차 처음 셋팅 - 이동 상태 1")
	public void carsInitStatus() {

	}
		int totalCarNum = 3;
		race.setInitRace(totalCarNum);

		for(int car = 0; car < totalCarNum; car++) {
			Assertions.assertEquals(DEFAULT_STATUS, carService.carStatus(car));
		}
	}
