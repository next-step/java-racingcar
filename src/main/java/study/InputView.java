package study;

import java.util.Scanner;

public class InputView {

	private int carCount;
	private int executionCount;

	public void setValues() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("자동차 대수는 몇 대 인가요?");
		carCount = scanner.nextInt();

		System.out.println("시도할 회수는 몇 회 인가요?");
		executionCount = scanner.nextInt();
	}

	public int getCarCount() {
		return this.carCount;
	}
	public int getExecutionCount() { return this.executionCount; }
}
