package racingCar.ui;

import racingCar.game.GameRequest;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
	@Override
	public GameRequest gameRequest() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("자동차 대수는 몇 대 인가요?");
		int carCount = scanner.nextInt();
		System.out.println("시도할 횟수는 몇 회 인가요?");
		int tryCount = scanner.nextInt();
		scanner.close();
		return new GameRequest(carCount, tryCount);
	}
}
