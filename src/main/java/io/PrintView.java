package io;

import racingcar.Car;

import java.util.List;
import java.util.stream.Collectors;

public class PrintView {
	private static final String RESULT_MESSAGE = "실행 결과";

	public static void printResultMessage() {
		System.out.println("\n" + RESULT_MESSAGE);
	}

	public static void printWinnerMessage(List<Car> cars) {
		String winnerName = cars.stream().map(Car::getName).collect(Collectors.joining(", "));
		System.out.println(winnerName + "가 최종 우승했습니다.");
	}

	public static void printPosition(Car car) {
		System.out.print(car.getName() + " : " + "-".repeat(car.getPosition()));

		printEmptyLine();
	}

	public static void printEmptyLine() {
		System.out.println();
	}
}
