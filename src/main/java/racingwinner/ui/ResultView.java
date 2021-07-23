package racingwinner.ui;

import racingwinner.domain.Car;

import java.util.List;
import java.util.Set;

public class ResultView {

	private static final String MOVE_SIGN = "-";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

	private ResultView() {
		throw new IllegalStateException();
	}

	public static void result(List<Car> cars) {
		for (Car car : cars) {
			print(car);
		}
		System.out.println();
	}

	private static void print(Car car) {
		StringBuilder totalSign = new StringBuilder();
		totalSign.append(car.getName())
		         .append(" : ");
		for (int i = 0; i < car.getForwardCount(); i++) {
			totalSign.append(MOVE_SIGN);
		}
		System.out.println(totalSign);
	}

	public static void printWinner(Set<String> winners) {
		System.out.println(String.join(",", winners) + WINNER_MESSAGE);
	}

}
