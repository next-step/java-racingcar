package racing.view;

import racing.model.RacingCars;

public class UserView {

	private String carNames;

	private int tryRacingNumber;

	public void getUserInputAboutRacingGame() {

		// 유저: 주행할 차량 댓수 입력
		this.carNames = userInputPlayCarNames();

		// 유저: 레이싱 주행 횟수 입력
		this.tryRacingNumber = userInputPlayTryNumber();
	}

	/**
	 * 유저: 주행할 차량 댓수 입력 메서드
	 * @return 주행할 차량 수
	 * @throws IllegalArgumentException : 유저 입력 숫자가 아닐 시 에러 Throw
	 */
	private static int userInputPlayTryNumber() {

		UserOutput.printUserInputTryNumberMsg();

		return UserInput.userInputNumber();
	}

	/**
	 * 유저: 랜덤 레이싱 주행 횟수 입력 메서드
	 * @return 레이싱 주행 횟수
	 */
	private static String userInputPlayCarNames() {

		UserOutput.printUserInputCarNumberMsg();

		return UserInput.userInputString();
	}

	public String[] getCarNames() {
		return carNames.split(",");
	}

	public int getTryRacingNumber() {
		return tryRacingNumber;
	}

	public void getUserOutputCarLocation(RacingCars racingCars) {

		UserOutput.printCarLocation(racingCars);
	}

	public void getUserOutputWinnerRacingGame(String winnerCarsName) {

		UserOutput.printWinnerRacingGame(winnerCarsName);
	}
}
