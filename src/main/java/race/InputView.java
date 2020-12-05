package race;

import java.util.Scanner;

public class InputView {
	private static final String numberOfCarMessage = "자동차 대수는 몇 대 인가요?";
	private static final String numberOfTryTimesMessage = "시도할 회수는 몇 회 인가요?";

	private final Scanner in = new Scanner(System.in);

	public GameProcessor settingGame() {
		int numberOfCar;
		int numberOfTryTimes;

		System.out.println(numberOfCarMessage);
		numberOfCar = in.nextInt();

		System.out.println(numberOfTryTimesMessage);
		numberOfTryTimes = in.nextInt();

		return new GameProcessor(numberOfCar, numberOfTryTimes, new RandomMovePolicy());
	}
}
