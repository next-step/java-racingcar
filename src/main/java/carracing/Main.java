package carracing;

import carracing.car.Car;
import carracing.car.MovingStrategy;
import carracing.car.RandomRange;
import carracing.car.Winners;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Car> cars = InputView.inputCars(scanner);
		int tryingTimes = InputView.inputTryingNumber(scanner);

		ResultView.printResultPhrase();
		for (int i = 0; i < tryingTimes; i++) {
			racing(cars);
		}

		Winners winners = new Winners(cars);
		ResultView.printWinners(winners.winners());
	}

	public static void racing(List<Car> cars) {
		MovingStrategy movingStrategy = new RandomRange(0, 9);
		for (Car car : cars) {
			car.move(movingStrategy);
			ResultView.printMovingResult(car);
		}
		ResultView.empty();
	}
}
