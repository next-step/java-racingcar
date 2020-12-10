package racing;

import racing.model.RacingGame;
import racing.view.UserOutput;
import racing.view.UserView;

public class RacingCarMain {

	public static void main(String[] args) {

		try {

			// 레이싱 시작
			racingGameStart();
		} catch (IllegalArgumentException illegalArgumentException) {

			// 유저 입력 에서 시, 에러 결과 출력
			UserOutput.printUserErrorMsg(illegalArgumentException.getMessage());
		}

	}

	private static void racingGameStart() throws IllegalArgumentException {

		UserView view = new UserView();

		view.getUserInputAboutRacingGame();

		// 경주 차량 객체 생성
		RacingGame racingGame = new RacingGame(view.getCarNames());

		// 입력한 주행 횟수 만큼 반복
		for (int i = 0; i < view.getTryRacingNumber(); i++) {

			// 레이싱 차량들 랜덤 주행 시작
			racingGame.start();

			// 주행 결과 출력
			view.getUserOutputCarLocation(racingGame.getRacingCars());
		}

		view.getUserOutputWinnerRacingGame(racingGame.getWinner());
	}

}
