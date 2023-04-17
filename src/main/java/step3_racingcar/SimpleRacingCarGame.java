package step3_racingcar;

import step3_racingcar.domain.Cars;
import step3_racingcar.service.GameProcess;
import step3_racingcar.view.InputView;
import step3_racingcar.view.ResultView;

public class SimpleRacingCarGame {

	public static void main(String[] args) {
		int carCount = InputView.getCarCount();
		int tryCount = InputView.getTryCount();

		Cars cars = new Cars(carCount);
		GameProcess gameProcess = new GameProcess();
		ResultView resultView= new ResultView();
		resultView.printResult(gameProcess.play(tryCount,cars));
	}
}
