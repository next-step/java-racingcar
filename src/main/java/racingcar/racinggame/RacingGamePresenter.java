package racingcar.racinggame;

import racingcar.common.MessageType;

import static racingcar.common.Message.*;

public class RacingGamePresenter implements RacingGameContract.Presenter {

	private RacingGameContract.View view;
	private RacingGame racingGame;

	public RacingGamePresenter() {
		this.racingGame = new RacingGame();
	}

	@Override
	public void setView(RacingGameContract.View view) {
		this.view = view;
	}

	@Override
	public void start() {
		view.print(MessageType.INFO.message(GAME_START_MSG));

		while (!racingGame.isEnd()) {
			racingGame.play();
			view.print(MessageType.INFO.message(racingGame.getPlayCount()+PLAY_START_MSG));
			racingGame.getCars().forEach((car) ->
					view.print(MessageType.GAME.message(racingGame.getCarTraceSymbolByCar(car)))
			);
			view.print(MessageType.INFO.message(racingGame.getPlayCount() + PLAY_END_MSG));
			view.print(MessageType.EMPTY.message(""));
		}
		view.print(MessageType.INFO.message(GAME_END_MSG));
	}

	@Override
	public void setGameNum(int gameCount) {
		racingGame.setGameCount(gameCount);
	}

	@Override
	public void addCars(int carCount) {
		boolean isMakeCar = racingGame.makeCar(carCount);
		String msg = isMakeCar ? SUCCESS_MAKE_CAR_MSG : FAIL_MAKE_CAR_MSG;
		view.print(MessageType.INFO.message(msg));
	}


}
