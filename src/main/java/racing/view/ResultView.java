package racing.view;

import java.util.List;

import racing.domain.Car;

public class ResultView {

	private ResultView() {

	}

	public static void printRacingResult(List<Car> cars) {
		for (Car car: cars) {
			System.out.println(showDistanceOfMovement(car.getMove()));
		}
		System.out.println();
	}

	private static String showDistanceOfMovement(int move) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < move; i++) {
			sb.append('-');
		}

		return sb.toString();
	}
}
