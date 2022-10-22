package racingcar.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StandardInputView implements InputView {

	private static final String NAME_DELIMITER = ",";
	private static final Scanner SCANNER = new Scanner(System.in);

	@Override
	public List<String> readNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String input = SCANNER.nextLine();
		String[] names = input.split(NAME_DELIMITER);
		return List.of(names);
	}

	@Override
	public int readTrialCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return readPositive();
	}

	private int readPositive() {
		int input = readInt();
		if (input <= 0) {
			throw new InputMismatchException("양수를 입력해야 합니다");
		}
		return input;
	}

	private int readInt() {
		try {
			return SCANNER.nextInt();
		} catch (InputMismatchException exception) {
			throw new InputMismatchException("정수를 입력해야 합니다");
		}
	}
}
