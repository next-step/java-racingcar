package racingcar.view;

import java.util.List;

import racingcar.model.Car;

public class ResultView {
	private static final String WINNER_NAMES_JOIN_DELIMITER = ", ";
	private static final String POSITION_SYMBOL = "-";

	public static void print(List<Car> cars) {
		StringBuilder builder = new StringBuilder();
		for (Car car : cars) {
			builder.append(car.getName());
			builder.append(" : ");
			builder.append(convertPositionToSymbol(car.getCurrentPosition()));
			builder.append("\n");
		}

		System.out.println(builder);
	}

	private static String convertPositionToSymbol(int position) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i <= position; i++) {
			builder.append(POSITION_SYMBOL);
		}
		return builder.toString();
	}

	public static void printTitleAndWaitingCars(List<Car> cars) {
		System.out.println("\n실행 결과");
		print(cars);
	}

	public static void printWinners(List<String> winnerNames) {
		String winnerNamesToDelimitedString = String.join(WINNER_NAMES_JOIN_DELIMITER, winnerNames);
		System.out.println(winnerNamesToDelimitedString + "가 최종 우승했습니다.");
	}
}
