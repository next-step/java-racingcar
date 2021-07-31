package refactoring.view;

import java.util.List;

import refactoring.domain.Car;

public class ResultView {

	private ResultView() {

	}

	public static void printRacingResult(List<String> names) {
		String result = String.join(",", names);

		System.out.println(result + "가 최종 우승했습니다.");
	}
	
	public static void printRacingRecords(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.getCarName() + " : " + distance(car.getCarDistance()));
		}

		System.out.println();
	}

	private static String distance(int distance) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < distance; i++) {
			sb.append("-");
		}

		return sb.toString();
	}
}
