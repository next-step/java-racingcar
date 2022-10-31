package racing;

import java.util.InputMismatchException;
import java.util.List;

import racing.domain.Car;
import racing.domain.Count;
import racing.domain.RacingCars;
import racing.domain.RandomNum;
import racing.domain.RandomNumber;
import racing.exception.InvalidCarNameLengthException;
import racing.exception.NegativeNumberException;
import racing.view.InputView;
import racing.view.ResultView;
import racing.view.dto.CarMoveCountDto;
import racing.view.dto.CarNamesDto;

public class RacingGame {
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
		try {
			CarNamesDto carNamesDTO = inputView.askCarNames();
			RandomNum randomNum = new RandomNumber();
			RacingCars racingCars = new RacingCars(carNamesDTO.getCarNames(), randomNum);

			CarMoveCountDto carMoveCountDto = inputView.askCarMoveCount();
			Count carMoveCount = new Count(carMoveCountDto.getCarMoveCount());

			startRacing(racingCars, carMoveCount);

			List<Car> winners = racingCars.getWinnersOfRacing();
			resultView.printWinners(winners);
		} catch (InputMismatchException | NegativeNumberException | InvalidCarNameLengthException exception) {
			resultView.printExceptionMessage(exception);
			quit();
		}
	}

	private void startRacing(RacingCars racingCars, Count carMoveCount) {
		for (int i = 0; i < carMoveCount.getCount(); i++) {
			racingCars.moveCars();
			resultView.printCarStatuses(racingCars);
		}
	}

	private void quit() {
		System.exit(0);
	}
}
