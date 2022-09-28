package racingcar.step3_4;

import java.util.Scanner;

public class InputView {

	public static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
	public static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

	private final Scanner scanner = new Scanner(System.in);
	private final InputValidator inputValidator = new InputValidator();

	public InputView() {
	}

	public GameAttribute getGameAttribute() {
		return new GameAttribute(getRacingCarCount(), getTryCount());
	}

	private int getRacingCarCount() {
		printCarCountInputRequestMessage();
		return getInputToInt();
	}

	private void printCarCountInputRequestMessage() {
		System.out.println(CAR_COUNT_MESSAGE);
	}

	private int getTryCount() {
		printTryCountInputRequestMessage();
		return getInputToInt();
	}

	private void printTryCountInputRequestMessage() {
		System.out.println(TRY_COUNT_MESSAGE);
	}

	private int getInputToInt() {
		String inputValue = scanner.nextLine();

		return convertToInt(inputValue);
	}

	private int convertToInt(String value) {
		int intValue;
		try {
			intValue = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("숫자를 입력해주세요.");
		}
		inputValidator.isZeroOrNegative(intValue);

		return intValue;
	}
}
