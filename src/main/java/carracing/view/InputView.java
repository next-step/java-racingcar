package carracing.view;

import carracing.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	public static List<Car> inputCars(Scanner scanner) {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String[] inputCarNames = scanner.nextLine().split(",");

		List<Car> cars = new ArrayList<>();
		for (String inputCarName : inputCarNames) {
			cars.add(new Car(inputCarName));
		}

		return cars;
	}

	public static int inputTryingNumber(Scanner scanner) {
		System.out.println("시도할 회수는 몇 회 인가요?");
		int tryingNumber = scanner.nextInt();
		return tryingNumber;
	}
}
