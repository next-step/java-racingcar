package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RaceController {

	private final Scanner scanner = new Scanner(System.in);

	public void runRace() {
		int carInput = getIntegerInput();
		int roundInput = getIntegerInput();
		scanner.close();

		RaceService raceService = new RaceService(carInput, roundInput);
		raceService.runRace();
	}

	private int getIntegerInput() {
		InputView.printCarInputMessage();
		return parseValidInt();
	}

	private int parseValidInt() {
		int parsedValue;
		try {
			parsedValue = scanner.nextInt();
		} catch (InputMismatchException e) {
			throw new RuntimeException("정수만 입력할 수 있습니다.");
		}

		if (parsedValue <= 0) {
			throw new RuntimeException("1 이상의 정수만 입력할 수 있습니다.");
		}
		return parsedValue;
	}

}
