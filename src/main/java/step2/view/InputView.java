package step2.view;

import step2.domain.rules.*;

import java.util.Scanner;

public class InputView {

	private final String delimiter;

	private Scanner scanner;

	public InputView(String delimiter) {
		scanner = new Scanner(System.in);
		this.delimiter = delimiter;
	}

	public CarNameRule receiveNameOfCarsParticipated() {
		System.out.println(String.format("경주할 자동차 이름을 입력하세요(이름은 (%s)를 기준으로 구분).", delimiter));
		return new CarNameDefaultRule(scanner.nextLine(), delimiter);
	}

	public RaceRoundRule receiveNumberOfMaxRound() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return new RaceRoundDefaultRule(scanner.nextInt());
	}

}
