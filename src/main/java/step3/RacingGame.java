package step3;

public final class RacingGame {
	static final InputView inputView = new InputView();
	static final ResultView resultView = new ResultView();

	public static void main(String[] args) {
		int carCount = inputView.getCarCount();
		int moveCount = inputView.getMoveCount();

		Car[] cars = inputCars(carCount);
		race(cars, moveCount);
		resultView.printResult();
	}

	public static void race(Car[] cars, int moveCount) {
		for (Car car : cars) {
			for (int i = 0; i < moveCount; i++) {
				car.move();
			}
		}
	}

	public static Car[] inputCars(int count) {
		Car[] cars = new Car[count];
		for (int i = 0; i < count; i++) {
			cars[i] = new Car();
		}
		return cars;
	}
}
