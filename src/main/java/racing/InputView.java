package racing;

import java.util.Scanner;

class InputView {

	private final Scanner scanner = new Scanner(System.in);

	int inputCarNum() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return scanner.nextInt();
	}

	int inputRaceTurn() {
		System.out.println("시도할 회 수는 몇 회 인가요?");
		return scanner.nextInt();
	}
}
