package racingcar.view;

import java.util.Scanner;

public class InputView {

	public InputView() {
	}

	public String inputTotalCarNum(Scanner sc) {
		System.out.println("레이싱에 참여할 자동차 이름을 입력하세요! (이름은 쉼표를 기준으로 구분)");
		return sc.next();
	}

	public int inputTotalRound(Scanner sc) {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return sc.nextInt();
	}
}
