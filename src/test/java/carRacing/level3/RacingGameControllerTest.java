package carRacing.level3;


import carRacing.level3.controller.RacingGameController;
import carRacing.level3.service.strategy.RandomMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameControllerTest {

	RacingGameController race = new RacingGameController();

	@Test
	@DisplayName("경주시작")
	public void driveCar() {
		race.gameStart(new RandomMovingStrategy());
	}

}
