package racingGame.domain;

public class FixedDriveOnRacingCar implements DriveOnRacingCar {

	private int moveNumber;
	private int MOVABLENUMBER = 4;
	
	public FixedDriveOnRacingCar(int moveNumber) {
		this.moveNumber = moveNumber;
	}

	@Override
	public boolean checkDriveOnRacingCar() {
		return moveNumber >= MOVABLENUMBER;
	}
}
