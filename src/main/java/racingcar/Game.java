package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.movestrategy.MoveStrategy;
import racingcar.movestrategy.NumberOverFourStrategy;
import racingcar.numberstrategy.NumberStrategy;
import racingcar.numberstrategy.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

	private static final InputView INPUT_VIEW = new InputView();
	private static final OutputView OUTPUT_VIEW = new OutputView();

	public static void main(String[] args) {
		int carCount = getCarCount();
		int trialCount = getTrialCount();

		Cars cars = new Cars(carCount);
		move(cars, trialCount);
	}

	private static void move(Cars cars, int trialCount) {
		List<Result> results = new ArrayList<>();
		for (int i = 0; i < trialCount; ++i) {
			moveOnce(cars);
			accumulateResult(cars, results);
		}
		OUTPUT_VIEW.printResults(results);
	}

	private static void accumulateResult(Cars cars, List<Result> results) {
		List<Integer> positions = cars.getPositions();
		results.add(new Result(positions));
	}

	private static void moveOnce(Cars cars) {
		NumberStrategy numberStrategy = new RandomNumber(9);
		MoveStrategy moveStrategy = new NumberOverFourStrategy(numberStrategy);
		cars.move(moveStrategy);
	}

	private static int getTrialCount() {
		OUTPUT_VIEW.promptTrialCount();
		return INPUT_VIEW.readTrialCount();
	}

	private static int getCarCount() {
		OUTPUT_VIEW.promptCarCount();
		return INPUT_VIEW.readCarCount();
	}
}
