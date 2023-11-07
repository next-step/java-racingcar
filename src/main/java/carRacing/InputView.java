package carRacing;

import java.util.Scanner;

public class InputView {

	private Scanner sc = new Scanner(System.in);

	public int inputCarCount() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return sc.nextInt();
	}

	public int inputMoveCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return sc.nextInt();
	}
}
