package racingcar.view;

import racingcar.util.ScannerUtils;

public final class InputView {
	public static int scanNumberOfCars() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return ScannerUtils.scanInt();
	}

	public static int scanNumberOfRounds() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return ScannerUtils.scanInt();
	}
}
