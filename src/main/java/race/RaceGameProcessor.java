package race;

import java.util.stream.IntStream;

public class RaceGameProcessor {
	public static final int START_INCLUSIVE = 0;
	private final RaceGame gameSubject;
	private final int numberOfTryTimes;

	public RaceGameProcessor(int numberOfCar, int numberOfTryTimes) {
		this.gameSubject = new RaceGame(numberOfCar);
		this.numberOfTryTimes = numberOfTryTimes;
	}

	public RaceGameProcessor(int numberOfCar, int numberOfTryTimes, MovePolicy movePolicy) {
		this.gameSubject = new RaceGame(numberOfCar, movePolicy);
		this.numberOfTryTimes = numberOfTryTimes;
	}

	public static RaceGameProcessor ofInputView(InputView inputView, MovePolicy movePolicy) {
		return new RaceGameProcessor(inputView.numberOfCar, inputView.numberOfTryTimes, movePolicy);
	}

	public RaceGame getGameSubject() {
		return gameSubject;
	}

	public void running() {
		IntStream.range(START_INCLUSIVE, numberOfTryTimes)
			.forEach(i -> gameSubject.notifyObserver());
	}
}
