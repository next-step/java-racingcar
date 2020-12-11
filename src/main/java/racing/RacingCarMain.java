package racing;

import racing.model.RacingGame;
import racing.model.service.RandomCarConditional;
import racing.view.UserView;

public class RacingCarMain {

	public static void main(String[] args) {
		UserView view = new UserView();

		try {
			// 유저 입력
			view.getUserInputAboutRacingGame();

			// 레이싱 시작
			racingGameStart(view);

		} catch (IllegalArgumentException exception) {

			// 유저 입력 에서 시, 에러 결과 출력
			view.getUserOutputError(exception.getMessage());
		}
	}

	private static void racingGameStart(UserView view) throws IllegalArgumentException {

		// 경주 차량 객체 생성
		RacingGame racingGame = new RacingGame(view.getCarNames());

		// 경주 시작
		play(racingGame, view);

		// 결과 출력
		view.getUserOutputWinnerRacingGame(racingGame.getWinner());
	}

	private static void play(RacingGame racingGame, UserView view) {
		
		// 입력한 주행 횟수 만큼 반복
		while (view.isTryGame()) {

			// 레이싱 차량들 랜덤 주행 시작
			racingGame.start(new RandomCarConditional());

			// 주행 결과 출력
			view.getUserOutputCarLocation(racingGame.getRacingCars());
		}
	}
}
