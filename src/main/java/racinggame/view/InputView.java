package racinggame.view;

import java.util.Scanner;

public class InputView {
	private static final Scanner sc = new Scanner(System.in);

	public int printAndGetCarCount() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return sc.nextInt();
	}

	public String printAndGetCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return sc.nextLine();
	}

	public int printAndGetMoveCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return sc.nextInt();
	}
}
