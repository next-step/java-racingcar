package racingGame.domain;

public class RacingCar {

	private static final String MOVE = "-";
	private static final String STOP = "";
	private String carName;
	private String[] positions;
	
	public RacingCar(int countOfTime, String carName) {
		positions = new String[countOfTime];
		this.carName = carName;
	}

	public void move(int round) {
		DriveOnRacingCar movable = new RandomDriveOnRacingCar();
		if(movable.checkDriveOnRacingCar()) {
			positions[round] = MOVE;
			return;
		}
		positions[round] = STOP;
	}
	
	public String[] getRoundPositions() {
		return positions;
	}
}
