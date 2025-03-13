package racingcar;

public class RaceController {
	private final InputView inputView;
	private final OutputView outputView;
	private RaceModel race;

	public RaceController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void startRace() {
		getInputs();
		runRounds();
	}

	private void getInputs() {
		inputView.printCarInputMessage();
		int carInput = InputHandler.parseValidInt();
		inputView.printRoundInputMessage();
		int roundInput = InputHandler.parseValidInt();
		race = new RaceModel(roundInput, carInput);
	}

	private void runRounds() {
		outputView.printResultMessage();
		while (race.getRemainingRounds() > 0) {
			runOneRound();
		}
	}

	private void runOneRound() {
		for (CarModel car : race.getCars()) {
			moveCar(car);
		}
		race.reduceRound();
		outputView.printEndOneRound();
	}

	private void moveCar(CarModel car) {
		if (CarMoveHandler.canGo()) {
			car.go();
		}
		outputView.printCarDistance(car.getDistance());
	}

}
