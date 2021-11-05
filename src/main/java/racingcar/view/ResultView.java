package racingcar.view;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.RacingGame;

public class ResultView {
	private static final String WINNER_NAMES_JOIN_DELIMITER = ", ";
	private static final String POSITION_SYMBOL = "-";

	public static void print(RacingGame racingGame) {
		List<Car> cars = racingGame.getCars();

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

	public static void printTitleAndWaitingCars(RacingGame racingGame) {
		System.out.println("\n실행 결과");
		print(racingGame);
	}

	public static void printWinners(RacingGame racingGame) {
		List<String> winnerNames = racingGame.getWinnerNames();
		String winnerNamesToDelimitedString = String.join(WINNER_NAMES_JOIN_DELIMITER, winnerNames);
		System.out.println(winnerNamesToDelimitedString + "가 최종 우승했습니다.");
	}
}
