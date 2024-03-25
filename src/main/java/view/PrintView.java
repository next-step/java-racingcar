package view;

import racingcar.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class PrintView {
	private static final String RESULT_MESSAGE = "실행 결과";

	public static void printResultMessage() {
		System.out.println("\n" + RESULT_MESSAGE);
	}

	public static void printWinnerMessage(List<Car> cars) {
		System.out.println(cars.stream()
				.map(Car::getCarName)
				.collect(Collectors.joining(",")) + "가 최종 우승했습니다.");
	}

	public static void printPosition(List<Car> cars) {
		cars.forEach(car ->
				System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()))
		);
	}

	public static void printEmptyLine() {
		System.out.println();
	}
}
