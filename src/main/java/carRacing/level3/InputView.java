package carRacing.level3;

import java.util.Scanner;

public class InputView {

	private final Scanner scanner;

	public InputView() {
		scanner = new Scanner(System.in);
	}

	public int askNumberofCars() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return scanner.nextInt();
	}

	public int askValueofRound() {
		System.out.println("시도 회수는 몇회인가요?");
		return scanner.nextInt();
	}

}

