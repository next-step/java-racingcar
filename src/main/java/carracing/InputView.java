package carracing;

import carracing.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	public static List<Car> inputCars(Scanner scanner) {
		List<Car> cars = new ArrayList<>();

		System.out.println("자동차 대수는 몇 대 인가요?");
		int carsNumber = scanner.nextInt();
		for (int i = 0; i < carsNumber; i++) {
			cars.add(new Car("carName"));
		}

		return cars;
	}

	public static int inputTryingNumber(Scanner scanner) {
		System.out.println("시도할 회수는 몇 회 인가요?");
		int tryingNumber = scanner.nextInt();

		return tryingNumber;
	}
}
