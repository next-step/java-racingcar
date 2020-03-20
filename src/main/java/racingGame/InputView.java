package racingGame;

import java.util.Scanner;

public class InputView {
	private static String GET_COUNT_OF_CARS_MSG = "자동차 대수는 몇 대 인가요?";
	private static String GET_TIMES_OF_CARS_GO_MSG = "시도할 회수는 몇 회 인가요?";

	private String value;
	private int number;

	public void startInput(){
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		String value = scanner.nextLine();
		int number = scanner.nextInt();
	}

	public String getValue() {
		return value;
	}

	public int getNumber() {
		return number;
	}
}
