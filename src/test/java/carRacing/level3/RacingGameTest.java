package carRacing.level3;

import carRacing.level3.controller.RacingGame;
import carRacing.level3.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

	public static final Integer DEFAULT_STATUS = 1;

	RacingGame race = new RacingGame();
	CarService carService = new CarService();

	@Test
	@DisplayName("전체 자동차 처음 셋팅 - 이동 상태 1")
	public void carsInit() {

		int totalCarNum = 3;
		race.initRace(totalCarNum);

		for (int car = 0; car < totalCarNum; car++) {
			Assertions.assertEquals(DEFAULT_STATUS, carService.carMovingLocation(car));
		}
	}

	@Test
	@DisplayName("전체 자동차 운전 시작")
	public void driveCar() {
		int totalCarNum = 3;
		race.driveCar(totalCarNum);
	}

	@Test
	@DisplayName("경기 시작 - 라운드 만큼 운전 반복")
	public void gameStart(){
		race.gameStart();
	}
}
