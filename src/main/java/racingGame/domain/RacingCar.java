package racingGame.domain;

public class RacingCar {

	private String MOVE = "-";
	private String STOP = "";

	public String move() {
		DriveOnRacingCar movable = new RandomDriveOnRacingCar();
		if(movable.checkDriveOnRacingCar()) {
			return MOVE;
		}
		return STOP;
	}
}
