package racing.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);
	private static final int NAME_MAX_LENGTH = 5;

	private InputView() {

	}

	public static String[] inputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

		String input = scanner.nextLine();
		String[] names = input.split(",");

		return Arrays.stream(names)
			.filter(InputView::validate)
			.toArray(String[]::new);
	}

	public static int inputTryCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");

		return scanner.nextInt();
	}

	private static boolean validate(String name) {
		return name.length() <= NAME_MAX_LENGTH;
	}
}
