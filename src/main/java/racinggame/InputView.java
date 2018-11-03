package racinggame;

import java.util.Scanner;

/**
 * Created by hspark on 03/11/2018.
 */
public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputCarAmount() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return scanner.nextInt();
	}

	public static int inputTryCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return scanner.nextInt();
	}
}
