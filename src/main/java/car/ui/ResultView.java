package car.ui;

import java.util.List;

import car.Car;

public class ResultView {

	private static final String INIT_PRINT_TEXT = "실행 결과";
	private static final char LOCATION_REPRESENTATION_CHARACTER = '-';
	private static final String WINNER_TEXT_DELIMITER = ", ";
	private static final String WINNER_TEXT_POSTFIX = "가 최종 우승했습니다.";

	public static void initPrint() {
		System.out.println(INIT_PRINT_TEXT);
	}

	public static void printCurrentStatus(List<Car> cars) {
		for (Car car : cars) {
			printName(car.getName());
			printLocation(car.currentLocation());
			lineSpace();
		}
		lineSpace();
	}

	private static void printName(String carName) {
		System.out.print(carName + " : ");
	}

	private static void printLocation(int input) {
		for (int i = 0; i < input; i++) {
			System.out.print(LOCATION_REPRESENTATION_CHARACTER);
		}
	}

	public static void printWinners(List<String> winners) {
		System.out.print(String.join(WINNER_TEXT_DELIMITER, winners) + WINNER_TEXT_POSTFIX);
		lineSpace();
	}

	private static void lineSpace() {
		System.out.println();
	}
}
