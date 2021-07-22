package racing.view;

import java.util.List;

import racing.domain.Car;

public class ResultView {

	private ResultView() {

	}

	public static void printRacingResult(List<Car> cars) {
		for (Car car: cars) {
			System.out.println(car.toString());
		}
		System.out.println();
	}
}
