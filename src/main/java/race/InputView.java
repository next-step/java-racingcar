package race;

import java.util.Scanner;

public class InputView {
	private static final String numberOfCarMessage = "자동차 대수는 몇 대 인가요?";
	private static final String numberOfTryTimesMessage = "시도할 회수는 몇 회 인가요?";
	private static final Scanner in = new Scanner(System.in);

	public final int numberOfCar;
	public final int numberOfTryTimes;

	public InputView(int numberOfCar, int numberOfTryTimes) {
		this.numberOfCar = numberOfCar;
		this.numberOfTryTimes = numberOfTryTimes;
	}

	public static InputView settingInputView() {
		System.out.println(numberOfCarMessage);
		int numberOfCar = in.nextInt();

		System.out.println(numberOfTryTimesMessage);
		int numberOfTryTimes = in.nextInt();

		return new InputView(numberOfCar, numberOfTryTimes);
	}
}
