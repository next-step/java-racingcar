package racingGame.logic.logic;

public class RacingGame {
	private static int RANDOM_RANGE = 10;
	private static int GO_THRESHOLD = 4;
	private int time;
	private int[] carPositions;

	public RacingGame(int cars) {
		this.carPositions = new int[cars];
	}

	public int[] move() {
		for (int i = 0; i < carPositions.length; i++) {
			carPositions[i] = moveCar(carPositions[i]);
		}
		time++;
		return carPositions.clone();
	}

	private int moveCar(int car) {
		if (canGo()) {
			car++;
		}
		return car;
	}

	private boolean canGo() {
		return Math.random() * RANDOM_RANGE > GO_THRESHOLD;
	}

	public int getTime() {
		return time;
	}

}
