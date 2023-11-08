package racing.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public InputView() {
	}

	private boolean isVaild(String input) {
		return input.length() <= 5;
	}

	private boolean inputValidation(String[] inputs) {
		boolean flag = true;
		for (String input : inputs) {
			flag = isVaild(input);
		}
		return flag;
	}

	public String[] cars() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
		String[] inputs = scanner.nextLine().split(",");
		if (inputValidation(inputs)) {
			return null;
		}
		return inputs;
	}

	public int attempts() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return scanner.nextInt();
	}

}
