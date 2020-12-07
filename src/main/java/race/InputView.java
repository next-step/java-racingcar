package race;

import java.util.Scanner;

public class InputView {
	private static final String numberOfCarMessage = "자동차 대수는 몇 대 인가요?";
	private static final String nameOfCarMessage = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String numberOfTryTimesMessage = "시도할 회수는 몇 회 인가요?";
	private static final Scanner in = new Scanner(System.in);

	public static InputValue makeGameInputValue() {
		System.out.println(nameOfCarMessage);
		String nameOfCar = in.next();

		System.out.println(numberOfTryTimesMessage);
		int numberOfTryTimes = in.nextInt();

		return new InputValue(nameOfCar, numberOfTryTimes);
	}
}
