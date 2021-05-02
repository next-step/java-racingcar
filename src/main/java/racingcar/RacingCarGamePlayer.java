package racingcar;

import java.util.Scanner;

public class RacingCarGamePlayer {
	public static void play() {
		Scanner scan = new Scanner(System.in);
		String carNames = askCarNames(scan);
		int roundCount = askRoundCount(scan);
		scan.close();
	}

	private static String askCarNames(Scanner scan) {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)");
		return scan.next();
	}

	private static int askRoundCount(Scanner scan) {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return scan.nextInt();
	}
}
