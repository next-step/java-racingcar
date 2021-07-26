package racingrefactoring.ui;

import racingrefactoring.domain.Car;
import racingrefactoring.domain.Cars;

import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {

	private static final String MOVE_SIGN = "-";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

	private ResultView() {
		throw new IllegalStateException();
	}

	public static void result(Cars cars) {
		for (Car car : cars.list()) {
			print(car);
		}
		System.out.println();
	}

	private static void print(Car car) {
		String totalSign = String.format("%s : %s", car.name(), signs(car.forwardCount()));
		System.out.println(totalSign);
	}

	private static String signs(int forwardCount) {
		StringBuilder signs = new StringBuilder();
		for (int i = 0; i < forwardCount; i++) {
			signs.append(MOVE_SIGN);
		}
		return signs.toString();
	}

	public static void printWinner(Cars winners) {
		System.out.println(String.join(",", getNames(winners)) + WINNER_MESSAGE);
	}

	private static Set<String> getNames(Cars winners) {
		return winners.list().stream().map(Car::name).collect(Collectors.toSet());
	}

}
