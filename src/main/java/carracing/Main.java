package carracing;

import carracing.car.Car;
import carracing.car.MovingStrategy;
import carracing.car.RandomRange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Car> cars = InputView.inputCars(scanner);
		int tryingTimes = InputView.inputTryingNumber(scanner);

		ResultView.printResultPhrase();
		for (int i = 0; i < tryingTimes; i++) {
			racing(cars);
		}
	}

	public static void racing(List<Car> cars) {
		MovingStrategy movingStrategy = new RandomRange(0, 9);
		for (Car car : cars) {
			car.move(movingStrategy);
			ResultView.printMovingResult(car);
			List<Car> winners = winner(cars);
		}
		ResultView.empty();
	}

	private static List<Car> winner(List<Car> cars) {
		new ArrayList<>();
		int maxMovingDistance = cars.stream()
				.map(Car::movingDistance)
				.max(Comparator.comparingInt(movingDistance -> movingDistance))
				.orElseThrow(NoSuchElementException::new);

		List<Car> winners = cars.stream()
				.filter(car -> car.movingDistance() == maxMovingDistance)
				.collect(Collectors.toList());

		return winners;
	}
}
