package step2.view;

import step2.domain.rules.CarNumberDefaultRule;
import step2.domain.rules.CarNumberRule;
import step2.domain.rules.RaceRoundDefaultRule;
import step2.domain.rules.RaceRoundRule;

import java.util.Scanner;

public class InputView {

	private Scanner scanner;

	public InputView() {
		scanner = new Scanner(System.in);
	}

	public CarNumberRule receiveNumberOfCarsParticipated() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return new CarNumberDefaultRule(scanner.nextInt());
	}

	public RaceRoundRule receiveNumberOfMaxRound() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return new RaceRoundDefaultRule(scanner.nextInt());
	}

}
