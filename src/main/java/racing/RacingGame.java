package racing;

import java.util.InputMismatchException;
import java.util.List;

import racing.domain.Car;
import racing.domain.RacingCars;
import racing.domain.RandomNum;
import racing.domain.RandomNumber;
import racing.exception.InvalidCarNameLengthException;
import racing.exception.NegativeNumberException;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {

	private static final String CAR_MOVE_COUNT_QUESTION = "시도할 횟수는 몇 회 인가요?";

	private final InputView inputView;
	private final ResultView resultView;

	public RacingGame(InputView inputView, ResultView resultView) {
		this.inputView = inputView;
		this.resultView = resultView;
	}

	public RacingGame() {
		this(new InputView(), new ResultView());
	}

	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		racingGame.startGame();
	}

	private void startGame() {
		CarNamesDto carNamesDTO = inputView.askCarNames();
		RandomNum randomNum = new RandomNumber();
		RacingCars racingCars = new RacingCars(carNamesDTO.getCarNames(), randomNum);

		int carMoveCount = 0;
		try {
			carMoveCount = inputView.askCountQuestion(CAR_MOVE_COUNT_QUESTION);
		} catch (InputMismatchException | NegativeNumberException | InvalidCarNameLengthException exception) {
			System.out.println(exception.getMessage());
			quit();
		}

		startRacing(racingCars, carMoveCount);

		printWinners(racingCars);
	}

	private void printWinners(final RacingCars racingCars) {
		List<Car> winners = racingCars.getWinnersOfRacing();

		resultView.printWinners(winners);
	}

	private void startRacing(RacingCars racingCars, int carMoveCount) {
		for (int i = 0; i < carMoveCount; i++) {
			racingCars.moveCars();
			resultView.printCarStatuses(racingCars);
			System.out.println();
		}
	}

	private void quit() {
		System.exit(0);
	}
}
