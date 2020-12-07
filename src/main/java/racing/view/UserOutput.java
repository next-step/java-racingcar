package racing.view;

import java.util.List;

import racing.model.RacingCar;

public class UserOutput {

	private static final String PRINT_USER_INPUT_CAR_NUMBER_MSG = "자동차 대수는 몇 대 인가요?";
	private static final String PRINT_USER_INPUT_TRY_NUMBER_MSG = "시도할 회수는 몇 회 인가요?";
	private static final String PRINT_USER_CALCULATE_RESULT = "계산 결과: ";
	private static final String PRINT_NEXT_LINE = "\n";
	private static final String PRINT_TO_BE_CONTINUED = "게임을 새로 시작하려면 " + "1을 입력(아니면 종료)";
	private static final String PRINT_USER_INPUT_ERROR_MSG = "입력을 잘못하셨습니다. 숫자만 입력해 주세요.";

	private static final String PRINT_CAR_RACE_LOCATION = "-";

	private static void messagePrint(final String message) {

		System.out.print(message);
	}

	public static void printUserErrorMsg() {

		messagePrint(PRINT_USER_INPUT_ERROR_MSG + PRINT_NEXT_LINE);
	}

	public static void printUserInputCarNumberMsg() {

		messagePrint(PRINT_USER_INPUT_CAR_NUMBER_MSG + PRINT_NEXT_LINE);
	}

	public static void printUserInputTryNumberMsg() {

		messagePrint(PRINT_USER_INPUT_TRY_NUMBER_MSG + PRINT_NEXT_LINE);
	}

	public static void printCalculatorResult(int result) {

		messagePrint(PRINT_USER_CALCULATE_RESULT + result + PRINT_NEXT_LINE);
	}

	public static void printCarLocation(int distance) {

		for (int i = 0; i < distance; i++) {

			messagePrint(PRINT_CAR_RACE_LOCATION);
		}

		messagePrint(PRINT_NEXT_LINE);
	}

	public static void printCarLocation(List<RacingCar> racingCars) {

		for (RacingCar car : racingCars) {

			printCarLocation(car.getDistance());
		}

		messagePrint(PRINT_NEXT_LINE);
	}
}
