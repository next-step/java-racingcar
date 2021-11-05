package racingcar.view;

import racingcar.util.ScannerUtils;

public final class InputView {
	public static String scanNameOfCars() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return ScannerUtils.scanString();
	}

	public static int scanNumberOfRounds() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return ScannerUtils.scanInt();
	}
}
