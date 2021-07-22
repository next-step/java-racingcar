package racingwinner.ui;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {


	private static final String QUESTION_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String QUESTION_REPEAT_COUNT = "시도할 회수는 몇 회 인가요?";
	public static final String WRONG_NAME_LENGTH_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다. 다시 입력 해주세요.";
	public static final String NAME_SEPARATOR = ",";
	private String[] carNames;
	private int repeatCount;

	public InputView() {
		Scanner scanner = new Scanner(System.in);
		inputName(scanner);
		inputRepeatCount(scanner);
	}

	private void inputName(Scanner scanner) {
		System.out.println(QUESTION_CAR_NAME);
		this.carNames = validName(scanner);
	}

	private String[] validName(Scanner scanner) {
		String[] names = scanner.nextLine().split(NAME_SEPARATOR);
		if (isWrongNames(names)) {
			return validName(scanner);
		}
		return names;
	}

	private boolean isWrongNames(String[] names) {
		if (Arrays.stream(names).anyMatch(name -> name.length() > 5)) {
			System.out.println(WRONG_NAME_LENGTH_MESSAGE);
			return true;
		}
		return false;
	}

	private void inputRepeatCount(Scanner scanner) {
		System.out.println(QUESTION_REPEAT_COUNT);
		this.repeatCount = scanner.nextInt();
	}

	public String[] getCarNames() {
		return carNames;
	}

	public int getRepeatCount() {
		return repeatCount;
	}

}
