package step5_racingcar_refactoring;

import step5_racingcar_refactoring.domain.Cars;
import step5_racingcar_refactoring.service.GameProcess;
import step5_racingcar_refactoring.view.InputView;
import step5_racingcar_refactoring.view.ResultView;

public class RacingCarGameRefactor {

	public static void main(String[] args) {
		String[] carName = InputView.getCarName();
		int tryCount = InputView.getTryCount();

		Cars cars = new Cars(carName);
		GameProcess gameProcess = new GameProcess();
		ResultView resultView= new ResultView();
		resultView.printResult(gameProcess.play(tryCount,cars));
	}
}
