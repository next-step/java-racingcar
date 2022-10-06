package carRacing;

import carRacing.level3.controller.RacingGameController;
import carRacing.level3.model.strategy.RandomMovingStrategy;

public class RacingApplication{

	public static void main(String[] args) {
		new RacingGameController().gameStart(new RandomMovingStrategy());
	}

}