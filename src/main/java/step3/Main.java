package step3;

import java.util.List;

import step3.domain.Racing;
import step3.domain.RacingResult;
import step3.view.InputView;
import step3.view.OutputView;

public class Main {
	public static void main(String[] args) {
		int cars = InputView.numberOfCars();
		int trials = InputView.numberOfTrials();

		List<RacingResult> result = new Racing(trials, cars).race();
		OutputView.viewResult(result);
	}
}