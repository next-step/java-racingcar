package study.step5.controller;

import java.util.List;

import study.step5.domain.car.Cars;
import study.step5.domain.movestrategy.RandomMoveStrategy;
import study.step5.domain.racinggame.RacingGame;
import study.step5.view.InputView;
import study.step5.view.OutputView;

public class RacingGameController {
	InputView inputView = new InputView();
	OutputView outputView = new OutputView();
	RacingGame racingGame;

	public void ready() {
		List<String> names = inputView.getNames();
		int round = inputView.getRound();

		racingGame = new RacingGame(new Cars().createByNames(names), round, new RandomMoveStrategy());
	}

	public void start() {
		while (racingGame.getCurrentRound() < racingGame.getRound()) {
			this.play();
		}
	}

	private void play() {
		racingGame.getParticipants().moveAll(racingGame.getMoveStrategy());
		racingGame.addCurrentRound();
		outputView.printRacingGame(racingGame.getParticipants());
	}

	public void end() {
		outputView.printWinners(racingGame.findWinners());
	}
}
