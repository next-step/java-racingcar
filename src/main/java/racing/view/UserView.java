package racing.view;

import java.util.List;

import racing.model.CarNames;
import racing.model.RacingCar;

public class UserView {

	private CarNames carNames;

	private int tryRacingNumber;

	public void getUserInputAboutRacingGame() {

		// 유저: 주행할 차량 댓수 입력
		this.carNames = userInputPlayCarNames();

		// 유저: 레이싱 주행 횟수 입력
		this.tryRacingNumber = userInputPlayTryNumber();
	}

	/**
	 * 유저: 랜덤 레이싱 주행 횟수 입력 메서드
	 * @return 레이싱 주행 횟수
	 * @throws IllegalArgumentException : 유저 입력 숫자가 아닐 시 에러 Throw
	 */
	private static int userInputPlayTryNumber() {

		UserOutput.printUserInputTryNumberMsg();

		return UserInput.userInputNumber();
	}

	/**
	 * 유저: 주행할 차량 댓수 입력 메서드
	 * @return 주행할 차량 수
	 */
	private static CarNames userInputPlayCarNames() {

		UserOutput.printUserInputCarNumberMsg();

		return new CarNames(UserInput.userInputString());
	}

	public CarNames getCarNames() {
		return this.carNames;
	}

	public int getTryRacingNumber() {
		return this.tryRacingNumber;
	}

	public void getUserOutputCarLocation(List<RacingCar> racingCars) {
		UserOutput.printCarLocation(racingCars);
	}

	public void getUserOutputWinnerRacingGame(String winnerCarsName) {
		UserOutput.printWinnerRacingGame(winnerCarsName);
	}

	public void getUserOutputError(String errorMessage) {
		UserOutput.printUserErrorMsg(errorMessage);
	}
}
