package race;

import java.util.stream.IntStream;

public class GameProcessor {
	public static final int START_INCLUSIVE = 0;
	private final GameSubject gameSubject;
	private final int numberOfTryTimes;

	public GameProcessor(int numberOfCar, int numberOfTryTimes) {
		this.gameSubject = new RaceGame(numberOfCar);
		this.numberOfTryTimes = numberOfTryTimes;
	}

	public GameProcessor(int numberOfCar, int numberOfTryTimes, MovePolicy movePolicy) {
		this.gameSubject = new RaceGame(numberOfCar, movePolicy);
		this.numberOfTryTimes = numberOfTryTimes;
	}

	public GameSubject getGameSubject() {
		return gameSubject;
	}

	public void running() {
		IntStream.range(START_INCLUSIVE, numberOfTryTimes)
			.forEach(i -> gameSubject.notifyObserver());
	}
}
