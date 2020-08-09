package step5.view.input;

import java.util.InputMismatchException;
import java.util.Scanner;

import static step3.constants.MessageConstant.PLEASE_INPUT_INTEGER;

public class SystemIn implements InputChannel{

	private static final Scanner SCANNER = new Scanner(System.in);

	@Override
	public int getIntValue() {
		try {
			return SCANNER.nextInt();
		} catch (InputMismatchException e) {
			throw new IllegalArgumentException(PLEASE_INPUT_INTEGER, e);
		} finally {
			SCANNER.nextLine();
		}
	}

	@Override
	public String getStringValue() {
		try {
			return SCANNER.next();
		} finally {
			SCANNER.nextLine();
		}
	}
}
