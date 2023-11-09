package carRacing;

import java.util.List;

public class CarMain {

	public static void main(String[] args) {
		InputView input = new InputView();
		String[] nameInputs = input.inputCarName();
		int numberOfAttempts = input.inputMoveCount();

		System.out.println("실행 결과");

		ResultView result = new ResultView();
		CarRacing carRacing = new CarRacing();
		List<Car> cars = carRacing.makeCars(nameInputs.length, nameInputs);
		RandomNumMaker randomNumMaker = new RandomNumMaker();

		for (int i = 0; i < numberOfAttempts; i++) {
			carRacing.moveCars(cars, randomNumMaker);
			result.showResult(cars);
		}
	}
}
