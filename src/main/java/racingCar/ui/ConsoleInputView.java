package racingCar.ui;

import racingCar.game.RacingGameRequest;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements InputView {

	@Override
	public RacingGameRequest gameRequestWithCounts() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("자동차 대수는 몇 대 인가요?");
		int carCount = scanner.nextInt();
		System.out.println("시도할 횟수는 몇 회 인가요?");
		int tryCount = scanner.nextInt();
		scanner.close();
		return new RacingGameRequest(carCount, tryCount);
	}

	@Override
	public RacingGameRequest gameRequestWithNames() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.)");
		String carNames = scanner.nextLine();
		System.out.println("시도할 횟수는 몇 회 인가요?");
		int tryCount = scanner.nextInt();
		scanner.close();
		return new RacingGameRequest(List.of(carNames.split(",")), tryCount);
	}

}
