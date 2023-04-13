package step3_racingcar;

import step3_racingcar.view.InputView;
import step3_racingcar.view.ResultView;

public class RacingApp {
	private static final InputView inputView = InputView.getInstance();
	private static final ResultView resultView = ResultView.getInstance();

	public static void main(String[] args) {

        inputView.racingSetting();

		resultView.printResult();
	}
}
