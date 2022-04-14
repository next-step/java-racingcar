package racingcar.ui;

import java.util.Scanner;

public class InputView {
	private int numberOfCars;
	private int rounds;

	public InputView() {
		inputCarNumber();
		inputTryNumber();
	}

	private void inputTryNumber() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		this.rounds = input();
	}

	private void inputCarNumber() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		this.numberOfCars = input();
	}

	private int input() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public int getNumberOfCars() {
		return numberOfCars;
	}

	public int getRounds() {
		return rounds;
	}
}
