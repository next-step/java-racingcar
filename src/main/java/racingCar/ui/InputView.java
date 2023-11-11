package racingCar.ui;

import racingCar.RacingApplication;

import java.util.Scanner;

public class InputView { // 사용자 입력이 무엇인지 알고, 다룰 수 있다.
	public static int carCount;
	public static int tryCount;

	public static void takeInputFromUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("자동차 대수는 몇 대 인가요?");
		carCount = scanner.nextInt();
		System.out.println("시도할 횟수는 몇 회 인가요?");
		tryCount = scanner.nextInt();
		scanner.close();
	}


}
