package racing.view;

import racing.model.RacingCar;
import racing.model.RacingCars;

public class UserOutput {

	private static final String PRINT_USER_INPUT_CAR_NUMBER_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String PRINT_USER_INPUT_TRY_NUMBER_MSG = "시도할 회수는 몇 회 인가요?";
	private static final String PRINT_USER_CALCULATE_RESULT = "계산 결과: ";
	private static final String PRINT_NEXT_LINE = "\n";
	private static final String PRINT_RACING_CAR_WINNER_MSG = "가 최종 우승했습니다.";

	private static final String PRINT_RACING_CAR_LOCATION = "-";

	private static void messagePrint(final String message) {

		System.out.print(message);
	}

	public static void printUserErrorMsg(String msg) {

		messagePrint(msg + PRINT_NEXT_LINE);
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

		for (int i = 0; i <= distance; i++) {

			messagePrint(PRINT_RACING_CAR_LOCATION);
		}

		messagePrint(PRINT_NEXT_LINE);
	}

	public static void printCarLocation(RacingCars racingCars) {

		for (RacingCar car : racingCars.getCars()) {
			printCarName(car.getCarName());
			printCarLocation(car.getDistance());
		}

		messagePrint(PRINT_NEXT_LINE);
	}

	private static void printCarName(String carName) {

		messagePrint(carName + " : ");
	}

	public static void printWinnerRacingGame(String winnerCarName) {

		messagePrint(winnerCarName + PRINT_RACING_CAR_WINNER_MSG + PRINT_NEXT_LINE);
	}
}
