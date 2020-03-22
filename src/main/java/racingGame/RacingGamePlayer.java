package racingGame;

import racingGame.domain.Car;
import racingGame.domain.Engine;
import racingGame.domain.RacingGame;
import racingGame.ui.InputView;
import racingGame.ui.ResultView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingGamePlayer {
	private static final Engine randomEngine = new RandomEngine();

	private InputView inputView;
	private ResultView resultView;

	public RacingGamePlayer() {
		inputView = new InputView();
		resultView = new ResultView();
	}

	public void racingStart() {
		inputView.startInput();
		RacingGame racingGame = new RacingGame(
				Arrays.stream(inputView.getRacers())
						.map(racer -> new Car(racer, randomEngine))
						.toArray(Car[]::new));

		resultView.printResultStart();
		for (int i = 0; i < inputView.getRacingTime(); i++) {
			resultView.printResult(
					racingGame.move()
							.stream()
							.collect(Collectors.toMap(Car::getRacer, Car::getDistance)));
			System.out.println();
		}
		resultView.printWinner(racingGame.getWinners());
	}

	public static void main(String[] args) {
		new RacingGamePlayer().racingStart();
	}
}
