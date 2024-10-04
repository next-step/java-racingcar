package step3.view;

import step3.domain.Car;

public final class ResultView {
	public static void printCurrentPosition(Car[] cars) {
		for (Car car : cars) {
			printCarPosition(car);
		}
		System.out.println("");
	}

	public static void printStart() {
		System.out.println("실행 결과");
	}

	private static void printCarPosition(Car car) {
		int carPosition = car.getPosition();
		for (int j = 0; j < carPosition; j++) {
			System.out.print("-");
		}
		System.out.println("");
	}
}
