package edu.nextstep.racing.view;

import edu.nextstep.racing.domain.Car;
import edu.nextstep.racing.domain.Cars;

public class ResultView {

	private ResultView() {
	}

	public static void printGameStart() {
		System.out.println("\n실행 결과");
	}

	public static void printCarsLocation(Cars cars) {
		for (Car car : cars.getAll()) {
			System.out.println(viewCarLocation(car));
		}
		System.out.println();
	}

	public static String viewCarLocation(Car car) {
		StringBuilder result = new StringBuilder(car.getName().getValue());
		result.append(" : ");
		for (int i = 0; i < car.getLocation().getValue(); i++) {
			result.append("-");
		}
		return result.toString();
	}

	public static void printWinners(Cars cars) {
		StringBuilder result = new StringBuilder("\n" + cars.getAll().get(0).getName().getValue());
		for (int i = 1; i < cars.getAll().size(); i++) {
			result.append(", ");
			result.append(cars.getAll().get(i).getName().getValue());
		}
		result.append("가 최종 우승했습니다.");
		System.out.println(result);
	}
}