package racingcar;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {
	private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분)";
	private static final String ROUND_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
	private static final Scanner SCANNER = new Scanner(System.in);

	private InputView() {
		throw new UnsupportedOperationException("유틸 클래스의 인스턴스를 생성할 수 없습니다.");
	}

	public static String getCarInput() {
		System.out.println(CAR_INPUT_MESSAGE);
		return getStringInput();
	}

	public static int getRoundInput() {
		System.out.println(ROUND_INPUT_MESSAGE);
		int roundInput = getIntegerInput();
		validateNaturalNumber(roundInput);
		return roundInput;
	}

	public static String getStringInput() {
		String input = SCANNER.nextLine();
		if (input == null || input.isBlank()) {
			throw new RuntimeException("입력값이 비어 있거나 공백만 포함할 수 없습니다.");
		}
		return input;
	}

	public static int getIntegerInput() {
		int parsedValue;
		try {
			parsedValue = SCANNER.nextInt();
		} catch (InputMismatchException e) {
			throw new RuntimeException("정수만 입력할 수 있습니다.");
		} catch (NoSuchElementException e) {
			throw new RuntimeException("입력값이 존재하지 않습니다.");
		}
		return parsedValue;
	}

	public static void validateNaturalNumber(int value) {
		if (value < 1) {
			throw new RuntimeException("1 이상의 정수만 입력할 수 있습니다.");
		}
	}

	public static void closeScanner() {
		SCANNER.close();
	}

}
