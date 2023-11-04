package carracing;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Car> cars = InputView.inputCars(scanner);
		int tryingTimes = InputView.tryingNumber(scanner);

		ResultView.resultPhrase();
		for (int i = 0; i < tryingTimes; i++) {
			racing(cars);
		}
	}

	public static void racing(List<Car> cars) {
		final RandomRange randomRange = new RandomRange(0, 9);
		for (Car car : cars) {
			car.move(randomRange);
			ResultView.printMovingResult(car.movingDistance());
		}
		ResultView.empty();
	}
}
