package racing;

import java.util.InputMismatchException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racing.domain.Car;
import racing.domain.RacingCars;
import racing.domain.RandomNumber;
import racing.exception.NegativeNumberException;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {

	private static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
	private static final String CAR_MOVE_COUNT_QUESTION = "자동차 갯수는 몇 대 인가요?";

	private final InputView inputView;
	private final ResultView resultView;
	private RacingCars racingCars;

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
		int carCount = 0;
		int carMoveCount = 0;

		try {
			carCount = inputView.askCountQuestion(CAR_COUNT_QUESTION);
			carMoveCount = inputView.askCountQuestion(CAR_MOVE_COUNT_QUESTION);
		} catch (InputMismatchException | NegativeNumberException exception) {
			System.out.println(exception.getMessage());
			quit();
		}

		RandomNumber randomNumber = new RandomNumber();
		racingCars = new RacingCars(IntStream.range(0, carCount).
			mapToObj(i -> new Car(randomNumber)).
			collect(Collectors.toList()));

		startRacing(carCount, carMoveCount);
	}

	private void startRacing(int carCount, int carMoveCount) {
		IntStream.range(0, carMoveCount)
			.forEach(i -> {
				racingCars.moveCars();
				resultView.printCarLocations(racingCars);
				System.out.println();
			});
	}

	private void quit() {
		System.exit(0);
	}
}
