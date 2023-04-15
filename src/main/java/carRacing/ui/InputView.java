package carRacing.ui;

import java.util.Scanner;

import carRacing.exception.TryCountException;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public String[] inputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return scanner.nextLine().split(",");
	}

	public int inputTryCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		int tryCount = scanner.nextInt();
		if (tryCount < 0) {
			throw new TryCountException("시도 횟수는 양의 정수만 입력 가능합니다.");
		}
		return tryCount;
	}
}
