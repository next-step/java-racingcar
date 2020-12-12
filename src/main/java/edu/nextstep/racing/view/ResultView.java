package edu.nextstep.racing.view;

import java.util.List;

import edu.nextstep.racing.domain.Car;

public class ResultView {

	private ResultView() {
	}

	public static void printGameStart() {
		System.out.println("\n실행 결과");
	}

	public static void printCarsLocation(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(viewCarLocation(car));
		}
		System.out.println();
	}

	public static String viewCarLocation(Car car) {
		StringBuilder result = new StringBuilder(car.getName());
		result.append(" : ");
		for (int i = 0; i < car.getLocation(); i++) {
			result.append("-");
		}
		return result.toString();
	}

	public static void printWinners(List<Car> cars) {
		if (cars == null || cars.isEmpty()) {
			System.out.println("\n최종 우승자는 없습니다.");
			return;
		}
		StringBuilder result = new StringBuilder("\n" + cars.get(0).getName());
		for (int i = 1; i < cars.size(); i++) {
			result.append(", ");
			result.append(cars.get(i).getName());
		}
		result.append("가 최종 우승했습니다.");
		System.out.println(result);
	}
}