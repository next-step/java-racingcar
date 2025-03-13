package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
	private static final Scanner SCANNER = new Scanner(System.in);

	private InputHandler() {
		throw new UnsupportedOperationException("유틸 클래스의 인스턴스를 생성할 수 없습니다.");
	}

	public static int parseValidInt() {
		int parsedValue;
		try {
			parsedValue = SCANNER.nextInt();
		} catch (InputMismatchException e) {
			throw new RuntimeException("정수만 입력할 수 있습니다.");
		}

		if (parsedValue <= 0) {
			throw new RuntimeException("1 이상의 정수만 입력할 수 있습니다.");
		}
		return parsedValue;
	}
}
