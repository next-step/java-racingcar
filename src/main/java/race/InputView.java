package race;

import java.util.Scanner;

public class InputView {
	private static final String numberOfCarMessage = "자동차 대수는 몇 대 인가요?";
	private static final String numberOfTryTimesMessage = "시도할 회수는 몇 회 인가요?";
	private static final Scanner in = new Scanner(System.in);

	public static InputValue makeGameInputValue() {
		System.out.println(numberOfCarMessage);
		int numberOfCar = in.nextInt();

		System.out.println(numberOfTryTimesMessage);
		int numberOfTryTimes = in.nextInt();

		return new InputValue(numberOfCar, numberOfTryTimes);
	}
}
