package step2.view;

import java.util.Scanner;

public class InputView {

	private Scanner scanner;

	public InputView() {
		scanner = new Scanner(System.in);
	}

	public int receiveNumberOfCarsParticipated() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return validateNumberOfCarsParticipated(scanner.nextInt());
	}

	private int validateNumberOfCarsParticipated(int inputNumberOfCarsParticipated) {
		if (inputNumberOfCarsParticipated <= 0) {
			System.out.println("자동차는 1대 이상이어야 합니다");
			System.exit(1);
		}
		return inputNumberOfCarsParticipated;
	}

	public int receiveNumberOfMaxRound() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return validateNumberOfMaxRound(scanner.nextInt());
	}

	private int validateNumberOfMaxRound(int inputNumberOfMaxRound) {
		if (inputNumberOfMaxRound <= 0) {
			System.out.println("시도 횟수는 1번 이상이어야 합니다");
			System.exit(1);
		}
		return inputNumberOfMaxRound;
	}

}
