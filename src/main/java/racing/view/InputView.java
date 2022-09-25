package racing.view;

import racing.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static List<Car> generateCars() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return generateCars(scanner.nextInt());
	}

	public static List<Car> generateCars(int count) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			cars.add(new Car());
		}
		return cars;
	}

	public static int inputTimes() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return scanner.nextInt();
	}
}
