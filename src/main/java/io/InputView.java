package io;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final InputValidation inputValidation = new InputValidation();

	public static String[] inputNamesOfCar() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String[] names = scanner.nextLine().split(",");

		for(String name : names) {
			try {
				inputValidation.validCarName(name);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				return inputNamesOfCar();
			}
		}

		return names;
	}

	public static int inputNumberOfTrial() {
		System.out.println("시도할 회수는 몇 회 인가요?");

		int numberOfTrial = scanner.nextInt();

		try {
			inputValidation.validNumberOfTrial(numberOfTrial);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputNumberOfTrial();
		}

		return numberOfTrial;
	}
}
