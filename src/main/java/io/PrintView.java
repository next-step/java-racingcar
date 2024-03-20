package io;

import racingcar.Car;

public class PrintView {
	private static final String RESULT_MESSAGE = "실행 결과";

	public static void printResultMessage() {
		System.out.println("\n" + RESULT_MESSAGE);
	}

	public static void printWinnerMessage(String winnerName) {
		System.out.println(winnerName + "가 최종 우승했습니다.");
	}

	public static void printPosition(Car car) {
		System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
	}

	public static void printEmptyLine() {
		System.out.println();
	}
}
