package step2.view;

import step2.domain.rules.*;

import java.util.Scanner;

public class InputView {

	private Scanner scanner;

	public InputView() {
		scanner = new Scanner(System.in);
	}

	public CarNameRule receiveNameOfCarsParticipated() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return new CarNameDefaultRule(scanner.nextLine());
	}

	public RaceRoundRule receiveNumberOfMaxRound() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return new RaceRoundDefaultRule(scanner.nextInt());
	}

}
