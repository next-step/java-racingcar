package racing.view;

import java.util.List;

import racing.model.CarNames;
import racing.model.RacingCar;
import racing.model.TryRaceNumber;

public class UserView {

	private CarNames carNames;

	private TryRaceNumber tryRaceNum;

	public void getUserInputAboutRacingGame() {

		// 유저: 주행할 차량 댓수 입력
		this.carNames = userInputPlayCarNames();

		// 유저: 레이싱 주행 횟수 입력
		this.tryRaceNum = userInputPlayTryNumber();
	}

	/**
	 * 유저: 랜덤 레이싱 주행 횟수 입력 메서드
	 * @return 레이싱 주행 횟수
	 * @throws IllegalArgumentException : 유저 입력 숫자가 아닐 시 에러 Throw
	 */
	private static TryRaceNumber userInputPlayTryNumber() {

		UserOutput.printUserInputTryNumberMsg();

		return new TryRaceNumber(UserInput.userInputString());
	}

	/**
	 * 유저: 주행할 차량 댓수 입력 메서드
	 * @return 주행할 차량 수
	 */
	private static CarNames userInputPlayCarNames() {

		UserOutput.printUserInputCarNumberMsg();

		return new CarNames(UserInput.userInputString());
	}

	public void getUserOutputWinnerRacingGame(String winnerCarsName) {

		UserOutput.printWinnerRacingGame(winnerCarsName);
	}

	public CarNames getCarNames() {

		return this.carNames;
	}

	public void getUserOutputError(String errorMessage) {

		UserOutput.printUserErrorMsg(errorMessage);
	}

	public void getUserOutputCarLocation(List<RacingCar> racingCars) {

		UserOutput.printCarLocation(racingCars);
	}

	public boolean isTryGame() {

		return this.tryRaceNum.isTryGame();
	}
}
