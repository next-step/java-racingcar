package racing;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

import racing.domain.Car;
import racing.domain.RacingCars;
import racing.domain.RandomNumber;
import racing.exception.InvalidCarNameLengthException;
import racing.exception.NegativeNumberException;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {

	private static final String CAR_MOVE_COUNT_QUESTION = "시도할 횟수는 몇 회 인가요?";
	private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

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
		RacingCars racingCars = new RacingCars(Collections.emptyList());
		int carMoveCount = 0;
		List<String> carNames = inputView.askCarNamesQuestion(CAR_NAME_QUESTION);
		try {
			racingCars = initRacingCars(carNames);
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

	private RacingCars initRacingCars(List<String> carNames) {
		RandomNumber randomNumber = new RandomNumber();

		List<Car> cars = carNames.stream()
			.map(carName -> new Car(carName, randomNumber))
			.collect(Collectors.toList());

		return new RacingCars(cars);
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
