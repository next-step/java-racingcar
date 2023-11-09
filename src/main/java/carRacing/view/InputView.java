package carRacing.view;

import java.util.Scanner;

public class InputView {

	private static final int MINIMUM_NATURAL_NUM = 1;
	private static final String REGEX = ",";

	private Scanner sc = new Scanner(System.in);

	public int inputMoveCount() {
		return getValidCount("시도할 회수는 몇 회 인가요?");
	}

	public int getValidCount(String text) {
		System.out.println(text);
		int numberOfAttempts = sc.nextInt();
		if (numberOfAttempts < MINIMUM_NATURAL_NUM) {
			throw new IllegalArgumentException("1 이상의 자연수를 입력해주세요.");
		}
		return numberOfAttempts;
	}

	public String[] inputCarName() {
		return getNames("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
	}

	private String[] getNames(String text) {
		System.out.println(text);
		String[] carNames = sc.nextLine().split(REGEX);
		for (String carName : carNames) {
			isCarNameValid(carName);
		}
		return carNames;
	}

	private void isCarNameValid(String carName) {
		if (carName.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다");
		}
	}
}
