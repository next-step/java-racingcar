package carracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	public static List<Car> inputCars(Scanner scanner) {
		List<Car> cars = new ArrayList<>();

		System.out.println("자동차 대수는 몇 대 인가요?");
		int carsNumber = scanner.nextInt();
		for (int i=0; i < carsNumber; i++) {
			Car car = new Car();
			cars.add(car);
		}

		return cars;
	}

	public static int tryingNumber(Scanner scanner) {
		System.out.println("시도할 회수는 몇 회 인가요?");
		int tryingNumber = scanner.nextInt();

		return tryingNumber;
	}
}
