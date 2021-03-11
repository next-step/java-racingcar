package im.juniq.racingcar;

import java.util.Scanner;

public class InputView {
	private static int carCount;
	private static int playCount;

	public static void scan() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		Scanner scanner = new Scanner(System.in);
		carCount = scanner.nextInt();
		System.out.println("시도할 회수는 몇 회 인가요?");
		playCount = scanner.nextInt();
	}

	public static int getCarCount() {
		return carCount;
	}

	public static int getPlayCount() {
		return playCount;
	}
}
