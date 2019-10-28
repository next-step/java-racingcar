package step3.view;

import java.util.Scanner;

public class InputView {
	// 차량 이름 입력 받음
	public String getInputCarName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
		String value = scanner.nextLine();
		if (value.trim().length() < 1) {
			return getInputCarName();
		}
		return value;
	}

	// 횟수 입력 받음
	public int getInputTime() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("시도할 횟수는 몇 회 인가요?");
		int value;
		try {
			value = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			return getInputTime();
		}

		return value;
	}
}
