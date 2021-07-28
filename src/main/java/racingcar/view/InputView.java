package racingcar.view;

import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);
	private static final String INPUT_RACING_CAR_NUM_STATEMENT = "자동차 대수는 몇 대 인가요?";
	private static final String INPUT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
	private static final String INPUT_CAR_NAME_LIST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

	private int inputIntValue() {
		return scanner.nextInt();
	}

	public int inputRacingCarNum() {
		System.out.println(INPUT_RACING_CAR_NUM_STATEMENT);
		return inputIntValue();
	}

	public int inputTryCount() {
		System.out.println(INPUT_TRY_COUNT);
		return inputIntValue();
	}

	public String[] inputCarNameList() {
		System.out.println(INPUT_CAR_NAME_LIST);
		return scanner.nextLine().split(",");
	}

	public void scannerClose() {
		scanner.close();
	}
}
