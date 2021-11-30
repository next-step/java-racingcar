package study.racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import study.racingcar.domain.Car;
import study.racingcar.domain.Cars;
import study.racingcar.domain.Name;

public class ResultView {

	private static final String COMMA_SPACE = ", ";
	private static final String DASH = "-";
	private static final String SEPARATOR = "";
	private static final String EQUALS_MESSAGE = ":";
	private static final String PLAY_RESULT_MESSAGE = "실행결과";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";


	private ResultView() {
		throw new AssertionError();
	}

	public static void printCurrentRacingResult(Cars cars) {
		printCarStatus(cars);
	}

	public static void printStart() {
		System.out.println(PLAY_RESULT_MESSAGE);
	}

	public static void newLine() {
		System.out.println(SEPARATOR);
	}

	public static void printCarStatus(Cars cars) {
		for (Car car : cars.status()) {
			printRace(car);
		}
		newLine();
	}

	private static void printRace(Car car) {
		System.out.print(car.valueOfCarName());
		System.out.print(EQUALS_MESSAGE);
		for (int i = 0; i < car.carPosition(); i++) {
			System.out.print(DASH);
		}
		newLine();
	}

	public static void printWinner(List<Name> winners) {
		String result = winners(winners);
		System.out.println(result + WINNER_MESSAGE);
	}

	public static String winners(List<Name> winners) {
		return winners.stream().map(Name::value).collect(Collectors.joining(COMMA_SPACE));
	}

}
