package carRacing.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final int MINIMUM_NATURAL_NUM = 1;
	private static final String COMMA = ",";
	public static final int MAX_CAR_NAME = 5;

	private Scanner sc = new Scanner(System.in);

	public int inputAttemptsCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		int numberOfAttempts = sc.nextInt();
		if (numberOfAttempts < MINIMUM_NATURAL_NUM) {
			throw new IllegalArgumentException("1 이상의 자연수를 입력해주세요.");
		}
		return numberOfAttempts;
	}

	public List<String> inputCarsName() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
		List<String> carNames = List.of(sc.nextLine().split(COMMA));
		for (String carName : carNames) {
			isCarNameValid(carName);
		}
		return carNames;
	}

	private void isCarNameValid(String carName) {
		if (carName.length() > MAX_CAR_NAME) {
			throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다");
		}
	}
}
