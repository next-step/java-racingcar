package racingcar;

import java.util.Scanner;

public class InputView {

	public InputView() {
	}

	public int inputTotalCarNum(Scanner sc) {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return sc.nextInt();
	}

	public int inputTotalRound(Scanner sc) {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return sc.nextInt();
	}
}
