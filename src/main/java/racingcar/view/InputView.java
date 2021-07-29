package racingcar.view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);
	private static final String INPUT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
	private static final String INPUT_CAR_NAME_LIST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

	private int inputIntValue() {
		int input = scanner.nextInt();
		if (input <= 0) {
			throw new NoSuchElementException("1보다 작은 값을 입력하셨습니다.");
		}
		return input;
	}

	public int inputTryCount() {
		System.out.println(INPUT_TRY_COUNT);
		return inputIntValue();
	}

	private void validateCarNames(String carNames) {
		boolean isExistFirstComma = carNames.charAt(0) == ',';
		boolean isExistLastComma = carNames.charAt(carNames.length() - 1) == ',';

		if (isExistFirstComma || isExistLastComma) {
			throw new InputMismatchException("콤마가 맨앞 또는 맨뒤에 위치하였습니다.");
		}
	}

	public String[] inputCarNames() {
		System.out.println(INPUT_CAR_NAME_LIST);
		String carNames = scanner.nextLine().trim();
		validateCarNames(carNames);

		return carNames.split(",");
	}

	public void scannerClose() {
		scanner.close();
	}
}
