package carracinggame;

import java.util.Scanner;

public class InputView {
	public static Scanner sc = new Scanner(System.in);

	public int printAndGetCarCount() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return getInputValue();
	}

	public int printAndGetMoveCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return getInputValue();
	}

	private int getInputValue() {
		return sc.nextInt();
	}
}
