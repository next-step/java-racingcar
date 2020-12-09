package race.view;

import java.util.Scanner;

public class InputView {
	private static final String nameOfCarMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
	private static final String numberOfTryTimesMessage = "시도할 회수는 몇 회 인가요?";
	private static final Scanner in = new Scanner(System.in);

	public static String askNameOfCarToUser() {
		System.out.println(nameOfCarMessage);
		return in.next();
	}

	public static int askNumberOfTryTimesToUser() {
		System.out.println(numberOfTryTimesMessage);
		return in.nextInt();
	}
}
