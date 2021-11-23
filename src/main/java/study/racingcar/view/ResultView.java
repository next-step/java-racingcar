package study.racingcar.view;

import java.util.List;

import study.racingcar.domain.Car;
import study.racingcar.domain.RacingGame;

public class ResultView {

	private static final String COMMA_SPACE = ", ";
	private static final String DASH = "-";
	private static final String PLAY_RESULT_MESSAGE = "실행결과";
	private static final String SEPARATOR = "";
	private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

	private ResultView() {
		throw new AssertionError();
	}

	public static void printCurrentRacingResult(RacingGame game) {
		List<Car> cars = game.carsCurrentStatus();
		printCarStatus(cars);
	}

	public static void printStart() {
		System.out.println(PLAY_RESULT_MESSAGE);
	}

	public static void newLine() {
		System.out.println(SEPARATOR);
	}

	public static void printCarStatus(List<Car> cars) {
		for (Car car : cars) {
			printRace(car);
		}
		newLine();
	}

	private static void printRace(Car car) {
		System.out.print(car.carName());
		System.out.print(":");
		for (int i = 0; i < car.carPosition(); i++) {
			System.out.print(DASH);
		}
		newLine();
	}

	public static void printWinner(List<String> winners){
		String result = String.join(COMMA_SPACE, winners);
		System.out.println(result + WINNER_MESSAGE);
	}



}
