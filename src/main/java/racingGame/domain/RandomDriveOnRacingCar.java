package racingGame.domain;

import java.util.Random;

public class RandomDriveOnRacingCar implements DriveOnRacingCar {
	
	private int MOVABLENUMBER = 4;
	
	@Override
	public boolean checkDriveOnRacingCar() {
		Random random = new Random();
		return random.nextInt(10) >= MOVABLENUMBER;
	}
}
