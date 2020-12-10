package racing;

import racing.model.RacingGame;
import racing.view.UserInput;
import racing.view.UserOutput;

public class RacingCarMain {

	public static void main(String[] args) {

		try {

			// 레이싱 시작
			racingGameStart();
		} catch (IllegalArgumentException illegalArgumentException) {

			// 유저 입력 에서 시, 에러 결과 출력
			UserOutput.printUserErrorMsg();
		}

	}

	private static void racingGameStart() throws IllegalArgumentException {

		// 유저: 주행할 차량 댓수 입력
		String carRaceNumber = userInputPlayCarNumber();

		// 유저: 레이싱 주행 횟수 입력
		int tryRaceNumber = userInputPlayTryNumber();

		// 경주 차량 객체 생성
		RacingGame racingGame = new RacingGame(carRaceNumber.split(","));

		// 입력한 주행 횟수 만큼 반복
		for (int i = 0; i < tryRaceNumber; i++) {

			// 레이싱 차량들 랜덤 주행 시작
			racingGame.start();

			// 주행 결과 출력
			UserOutput.printCarLocation(racingGame.getRacingCars());
		}

		UserOutput.printWinnerRacingGame(racingGame.getWinner());
	}

	/**
	 * 유저: 주행할 차량 댓수 입력 메서드
	 * @return 주행할 차량 수
	 * @throws IllegalArgumentException : 유저 입력 숫자가 아닐 시 에러 Throw
	 */
	private static int userInputPlayTryNumber() {

		UserOutput.printUserInputTryNumberMsg();

		return Integer.parseInt(UserInput.userInput());
	}

	/**
	 * 유저: 랜덤 레이싱 주행 횟수 입력 메서드
	 * @return 레이싱 주행 횟수
	 */
	private static String userInputPlayCarNumber() {

		UserOutput.printUserInputCarNumberMsg();

		return UserInput.userInput();
	}
}
