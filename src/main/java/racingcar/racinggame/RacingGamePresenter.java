package racingcar.racinggame;


import racingcar.car.Car;
import racingcar.common.MessageType;
import java.util.List;

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
		view.println(MessageType.INFO.message(GAME_START_MSG));

		while (!racingGame.isEnd()) {
			racingGame.play();
			view.println(MessageType.INFO.message(racingGame.getPlayCount()+PLAY_START_MSG));
			racingGame.getCars().forEach((car) -> {
						view.print(car.getName());
						view.print(" :: ");
						view.printCarPositionBySymbol(car.getPosition());
					}
			);
			view.println(MessageType.INFO.message(racingGame.getPlayCount() + PLAY_END_MSG));
			view.println(MessageType.EMPTY.message(""));
		}
		List<Car> winners = racingGame.getWinner();
		String winnerCarMsg = "";
		for( int i = 0; i < winners.size(); i++) {
			winnerCarMsg = winnerCarMsg.concat(winners.get(i).getName());
			if(i != winners.size() -1) {
				winnerCarMsg = winnerCarMsg.concat(",");
			}
		}
		view.println(MessageType.INFO.message(winnerCarMsg+ WINNER_MSG));
		view.println(MessageType.INFO.message(GAME_END_MSG));
	}

	@Override
	public void setGameNum(String gameCount) {
		int count = Integer.parseInt(gameCount);
		racingGame.setGameCount(count);
	}

	@Override
	public void addCars(String carNameString) {
		String[] carNameArr = carNameString.split(",");
		boolean isMakeCar = racingGame.makeCar(carNameArr);
		String msg = isMakeCar ? SUCCESS_MAKE_CAR_MSG : FAIL_MAKE_CAR_MSG;
		view.println(MessageType.INFO.message(msg));
	}
}

