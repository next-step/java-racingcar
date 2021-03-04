package im.juniq.racingcar;

import java.util.Scanner;

public class InputView {
	public static void scan() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		Scanner scanner = new Scanner(System.in);
		String value = scanner.nextLine();
		System.out.println("시도할 회수는 몇 회 인가요?");
		int number = scanner.nextInt();

		System.out.println("number = " + number);
		System.out.println("value = " + value);
	}
}
