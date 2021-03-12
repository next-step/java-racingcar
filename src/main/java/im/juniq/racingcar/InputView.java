package im.juniq.racingcar;

import java.util.Scanner;

public class InputView {
	private static int numberOfCars;
	private static int numberOfTries;

	public static void scan() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		Scanner scanner = new Scanner(System.in);
		numberOfCars = scanner.nextInt();
		System.out.println("시도할 회수는 몇 회 인가요?");
		numberOfTries = scanner.nextInt();
	}

	public static int getNumberOfCars() {
		return numberOfCars;
	}

	public static int getNumberOfTries() {
		return numberOfTries;
	}
}
