package step3;

public final class RacingGame {
	static final InputView inputView = new InputView();
	static final ResultView resultView = new ResultView();

	public static void main(String[] args) {
		int carCount = inputView.getCarCount();
		int moveCount = inputView.getMoveCount();
		Car[] cars = inputCars(carCount);
		resultView.printResult();
	}

	public static Car[] inputCars(int count) {
		return new Car[count];
	}
}
