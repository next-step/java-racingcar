package racingGame.domain;

import java.util.Arrays;

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
	
	public String getRoundPositions(int nRound) {
		return positions[nRound];
	}
	
	public int getCountOfPosition() {
		String position = "";
		for(int i = 0; i < positions.length; i++) {
			position += positions[i];
		}
		return position.length();
	}

	public String getCarName() {
		return carName;
	}
}
