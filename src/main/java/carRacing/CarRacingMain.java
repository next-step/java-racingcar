package carRacing;

import carRacing.car.Car;
import carRacing.car.CarRacing;
import carRacing.numberMaker.NumberMaker;
import carRacing.numberMaker.RandomNumberMaker;
import carRacing.view.InputView;
import carRacing.view.ResultView;
import java.util.List;

public class CarRacingMain {

	public static void main(String[] args) {
		InputView input = new InputView();
		String[] nameInputs = input.inputCarName();
		int numberOfAttempts = input.inputMoveCount();

		System.out.println("실행 결과");

		ResultView result = new ResultView();
		CarRacing carRacing = new CarRacing();
		List<Car> cars = carRacing.makeCars(nameInputs.length, nameInputs);
		NumberMaker numberMaker = new RandomNumberMaker();

		for (int i = 0; i < numberOfAttempts; i++) {
			carRacing.moveCars(numberMaker);
			result.showResult(cars);
		}
	}
}
