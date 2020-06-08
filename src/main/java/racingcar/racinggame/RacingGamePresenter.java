package racingcar.racinggame;


import racingcar.car.Car;
import racingcar.common.MessageType;
import java.util.List;

import static racingcar.common.Message.*;

public class RacingGamePresenter implements RacingGameContract.Presenter {

	private RacingGameContract.View view;
	private RacingGame racingGame;

	@Override
	public void setView(RacingGameContract.View view) {
		this.view = view;
	}

	@Override
	public void start(int gameCount,String[] carNames) {
		this.racingGame = new RacingGame(gameCount ,carNames);
		view.println(MessageType.INFO.message(SUCCESS_MAKE_CAR_MSG));
		view.println(MessageType.INFO.message(GAME_START_MSG));
		while (!racingGame.isEnd()) {
			racingGame.play();
			view.println(MessageType.INFO.message(racingGame.getPlayCount() + PLAY_START_MSG));
			printCurrGameStatus();
			view.println(MessageType.INFO.message(racingGame.getPlayCount() + PLAY_END_MSG));
			view.println(MessageType.EMPTY.message(""));
		}
		end();
	}

	private void printCurrGameStatus() {
		racingGame.getCars().forEach((car) -> {
					view.print(car.getName());
					view.print(" :: ");
					view.printCarPositionBySymbol(car.getPosition());
				}
		);
	}

	private void end() {
		List<Car> winners = racingGame.getWinner();
		String winnerCarMsg = "";
		for (int i = 0; i < winners.size(); i++) {
			winnerCarMsg = i != winners.size() - 1 ? winnerCarMsg.concat(winners.get(i).getName()+',') : winnerCarMsg.concat(winners.get(i).getName());
		}
		view.println(MessageType.INFO.message(winnerCarMsg+ WINNER_MSG));
		view.println(MessageType.INFO.message(GAME_END_MSG));
	}

}

