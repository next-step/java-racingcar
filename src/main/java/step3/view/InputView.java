package step3.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import step3.utils.Message;

public class InputView {

	public static int waiteInputCarCount() {
		System.out.println(Message.INPUT_CAR_COUNT);

		return waiteInputNumber();
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