package carRacing;

import java.util.List;

public class CarMain {

	public static void main(String[] args) {
		InputView input = new InputView();
		int carCount = input.inputCarCount();
		int moveCount = input.inputMoveCount();

		System.out.println("실행 결과");

		ResultView result = new ResultView();
		CarRacing carRacing = new CarRacing();
		List<Car> cars = carRacing.makeCars(carCount);
		RandomNumMaker randomNumMaker = new RandomNumMaker();

		for (int i = 0; i < moveCount; i++) {
			carRacing.moveCars(cars, randomNumMaker);
			result.showResult(cars);
		}
	}
}
