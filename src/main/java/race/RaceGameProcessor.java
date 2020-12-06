package race;

import java.util.stream.IntStream;

public class RaceGameProcessor {
	public static final int START_INCLUSIVE = 0;
	private final InputValue inputValue;
	private final RaceGame gameSubject;

	public RaceGameProcessor(InputValue inputValue, MovePolicy movePolicy) {
		this.inputValue = inputValue;
		this.gameSubject = new RaceGame(inputValue.numberOfCar(), movePolicy);
	}

	public RaceGame getGameSubject() {
		return this.gameSubject;
	}

	public void running() {
		IntStream.range(START_INCLUSIVE, this.inputValue.numberOfTryTimes())
			.forEach(i -> this.gameSubject.notifyObserver());
	}
}
