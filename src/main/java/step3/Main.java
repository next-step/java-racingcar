package step3;

import step3.domain.Racing;
import step3.view.InputView;
import step3.view.OutputView;

public class Main {
	public static void main(String[] args) {
		int cars = InputView.numberOfCars();
		int trials = InputView.numberOfTrials();

		int[][] result = new Racing(trials, cars).race();
		OutputView.viewResult(result);
	}
}