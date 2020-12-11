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

	/**
	 * 우승주 출력 메서드
	 * @param winnerCarsName: 주행 결과 우승자 문자열
	 */
	public void getUserOutputWinnerRacingGame(String winnerCarsName) {
		UserOutput.printWinnerRacingGame(winnerCarsName);
	}

	/**
	 * 유저 주행거리 출력 메서드
	 * @param racingCars: 레이싱 참가 차량 리스트
	 */
	public void getUserOutputCarLocation(List<RacingCar> racingCars) {

		UserOutput.printCarLocation(racingCars);
	}

	/**
	 * 유저 입력 에러 메세지 출력 메서드
	 * @param errorMessage: 유저 에러 메세지
	 */
	public void getUserOutputError(String errorMessage) {

		UserOutput.printUserErrorMsg(errorMessage);
	}

	/**
	 * 레이싱 사이클 진행 여무 확인 메서드
	 * @return 유저 입력 횟수 true / false
	 */
	public boolean isTryGame() {

		return this.tryRaceNum.isTryGame();
	}

	/**
	 * 유저 입력 리턴 메서드
	 * @return : 유저가 입력한 차량 리스트 문자열 리턴
	 */
	public CarNames getCarNames() {

		return this.carNames;
	}
}
