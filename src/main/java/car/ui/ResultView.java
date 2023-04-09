package car.ui;

import java.util.List;

import car.Car;

public class ResultView {

	private static final String INIT_PRINT_TEXT = "실행 결과";
	private static final char LOCATION_REPRESENTATION_CHARACTER = '-';

	public static void initPrint() {
		System.out.println(INIT_PRINT_TEXT);
	}

	public static void printCars(List<Car> cars) {
		for (Car car : cars) {
			print(car.currentLocation());
		}
		lineSpace();
	}

	public static void print(int input) {
		for (int i = 0; i < input; i++) {
			System.out.print(LOCATION_REPRESENTATION_CHARACTER);
		}
		System.out.println();
	}

	public static void lineSpace() {
		System.out.println();
	}
}
