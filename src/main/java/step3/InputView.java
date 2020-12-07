package step3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

	public int waiteInputCarCount() {
		System.out.println(Message.INPUT_CAR_COUNT);

		return waiteInputNumber();
	}

	public int waiteInputTryCount() {
		System.out.println(Message.INPUT_TRY_COUNT);

		return waiteInputNumber();
	}

	private int waiteInputNumber() {
		try {
			return new Scanner(System.in).nextInt();
		} catch (InputMismatchException exception) {
			throw new IllegalArgumentException(Message.INPUT_NUMBER);
		}
	}
}