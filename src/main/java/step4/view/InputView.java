package step4.view;

import java.util.Scanner;

import step4.domain.view.UserInput;

public final class InputView {
	private static Scanner scanner = new Scanner(System.in);

	public static UserInput getUserInput() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String nameString = scanner.nextLine();
		System.out.println("시도할 회수는 몇회인가요?");
		int moveCount = scanner.nextInt();

		return new UserInput(moveCount, nameString);
	}
}
