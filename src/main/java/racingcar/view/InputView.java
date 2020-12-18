package racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import racingcar.utils.Message;

public class InputView {

	public static String waiteInputCarNames() {
		System.out.println(Message.INPUT_CAR_NAME);

		return new Scanner(System.in).nextLine();
	}

	public static int waiteInputTryCount() {
		System.out.println(Message.INPUT_TRY_COUNT);

		return waiteInputNumber();
	}

	private static int waiteInputNumber() {
		try {
			return new Scanner(System.in).nextInt();
		} catch (InputMismatchException exception) {
			throw new IllegalArgumentException(Message.INPUT_NUMBER);
		}
	}
}