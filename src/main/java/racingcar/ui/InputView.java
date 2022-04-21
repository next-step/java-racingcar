package racingcar.ui;

import java.util.Scanner;

public class InputView {
	private Scanner scanner;
	private String carNames;
	private int rounds;

	public InputView() {
		this.scanner = new Scanner(System.in);
		inputCarNames();
		inputTryNumber();
	}

	private void inputTryNumber() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		this.rounds = scanner.nextInt();
	}

	private void inputCarNames() {
		System.out.println("경주할 자동차의 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
		this.carNames = scanner.next();
	}

	public String [] getCarNames() {
		return this.carNames.split(",");
	}

	public int getRounds() {
		return rounds;
	}
}
