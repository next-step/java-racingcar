package im.juniq.racingcar;

public class RacingGame {
	private Cars cars = new Cars();

	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		racingGame.play();
	}

	public void play() {
		InputView inputView = new InputView();
		inputView.scan();
		createCars(inputView.getCarNames());
		racing(inputView.getNumberOfTries());
	}

	private void createCars(String[] carNames) {
		cars.createCars(carNames);
	}

	private void racing(int numberOfTries) {
		for (int i = 0; i < numberOfTries; i++) {
			moveCars();
			printCarsMoveCount();
		}
	}

	private void moveCars() {
		cars.move();
	}

	private void printCarsMoveCount() {
		cars.printCarMoveCount();
	}
}
