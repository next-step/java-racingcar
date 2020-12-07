package race;

import java.util.stream.IntStream;

public class RaceGameController {
	public static final int START_INCLUSIVE = 0;
	private final InputValue inputValue;
	private final RaceGameModel raceGameModel;

	public RaceGameController(MovePolicy movePolicy) {
		this.inputValue = InputView.makeGameInputValue();
		this.raceGameModel = new RaceGameModel(this.inputValue.names(), movePolicy);
	}

	public RaceGameController(InputValue inputValue, MovePolicy movePolicy) {
		this.inputValue = inputValue;
		this.raceGameModel = new RaceGameModel(this.inputValue.names(), movePolicy);
	}

	public void registerGameObserver(GameObserver gameObserver) {
		this.raceGameModel.registerObserver(gameObserver);
	}

	public void start() {
		IntStream.range(START_INCLUSIVE, this.inputValue.numberOfTryTimes())
			.forEach(i -> this.raceGameModel.notifyObserver());
	}

	public String getNowCarsMoveStatus() {
		return raceGameModel.createGameResultMessage().parser();
	}

	public boolean isOverTryTimes() {
		return inputValue.numberOfTryTimes() <= raceGameModel.createGameResultMessage().getTryTimes();
	}
}
