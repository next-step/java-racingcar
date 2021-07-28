package racing.view;

import java.util.List;

import racing.domain.Car;

public class ResultView {

	private ResultView() {

	}

	public static void printRacingResult(List<Car> cars) {
		for (Car car: cars) {
			System.out.println(car.showDistanceOfMovement());
		}
		System.out.println();
	}

	public static void printRacingWinnerResult(String winnerNames) {
		System.out.println(winnerNames + "가 최종 우승했습니다.");
	}
}
