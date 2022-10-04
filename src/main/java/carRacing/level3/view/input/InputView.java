package carRacing.level3.view.input;

import java.util.Scanner;

public class InputView {

	private final Scanner scanner;

	public InputView() {
		scanner = new Scanner(System.in);
	}

	public int askNumberCars() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return scanner.nextInt();
	}

	public int askValueRound() {
		System.out.println("시도 회수는 몇회인가요?");
		return scanner.nextInt();
	}

}

