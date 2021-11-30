package study.racingcar;

import java.util.List;

import study.racingcar.domain.Cars;
import study.racingcar.domain.Name;
import study.racingcar.domain.RacingGame;
import study.racingcar.domain.strategy.MoveStrategy;
import study.racingcar.domain.strategy.RandomNumberStrategy;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class GamePlay {
	public static void main(String[] args) {
		playGame(new RandomNumberStrategy());
	}

	public static void playGame(MoveStrategy strategy) {
		RacingGame game = readyToGame();
		printStart();
		Cars racingResult = game.racing(strategy);
		findWinner(racingResult);
	}

	private static void findWinner(Cars racingResult) {
		List<Name> winner = racingResult.findWinner();
		ResultView.printWinner(winner);
	}

	private static RacingGame readyToGame() {
		List<Name> names = InputView.inputCarNames();
		int tryNo = InputView.inputTryNo();

		return new RacingGame(names, tryNo);
	}

	private static void printStart() {
		ResultView.printStart();
	}
}
