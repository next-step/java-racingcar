package racing.view;

import racing.model.Car;

import java.util.List;

public class OutputView {

	public static void printResultMessage() {
		System.out.println();
		System.out.println("실행 결과");
	}

	public static void printCarsPosition(List<Car> cars) {
		for (Car car : cars) {
			printCarPosition(car);
			System.out.println();
		}
		System.out.println();
	}

	private static void printCarPosition(Car car) {
		int position = car.getPosition();
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
	}
}
