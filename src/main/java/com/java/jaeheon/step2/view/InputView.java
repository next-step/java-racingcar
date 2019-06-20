package com.java.jaeheon.step2.view;

import java.util.Scanner;

public class InputView {
	private static Scanner scanner;

	public static int inputViewNumberOfCars() {
		return inputViewIntegerScanner("자동차 대수는 몇 대 인가요?");
	}

	public static String inputViewNameOfCars() {
		return inputViewStringScanner("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
	}

	public static int inputViewNumberOfAttempts() {
		return inputViewIntegerScanner("시도할 회수는 몇 회 인가요?");
	}

	private static int inputViewIntegerScanner(String message) {
		System.out.println(message);
		scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	private static String inputViewStringScanner(String message) {
		System.out.println(message);
		scanner = new Scanner(System.in);
		return scanner.next();
	}

}
