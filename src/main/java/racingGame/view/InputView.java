package racingGame.view;

import java.util.Scanner;

public class InputView {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static int inputCountOfCars(Scanner sc) {
		System.out.println("자동차의 대수는 몇 대 인가요?");
		return Integer.parseInt(sc.nextLine());
	}
	
	public static String inputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return sc.nextLine();
	}
	
	public static int inputCountOfTimes() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return Integer.parseInt(sc.nextLine());
	}
}
