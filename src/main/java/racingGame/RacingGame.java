package racingGame;

public class RacingGame {
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
		return Math.random() * 10 > 4;
	}

	public int getTime() {
		return time;
	}

}
