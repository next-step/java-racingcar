package racinggame;

import java.util.Scanner;

/**
 * Created by hspark on 03/11/2018.
 */
public class InputView {
	private Scanner scanner = new Scanner(System.in);

	public RacingGame input() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		int carAmount = scanner.nextInt();

		System.out.println("시도할 회수는 몇 회 인가요?");
		int tryCount = scanner.nextInt();

		return new RacingGame(carAmount, tryCount);
	}
}
