package step4_racingcar_winner;

import step4_racingcar_winner.domain.Cars;
import step4_racingcar_winner.service.GameProcess;
import step4_racingcar_winner.view.InputView;
import step4_racingcar_winner.view.ResultView;

public class RacingCarGameWinner {

	public static void main(String[] args) {
		String[] carName = InputView.getCarName();
		int tryCount = InputView.getTryCount();

		Cars cars = new Cars(carName);
		GameProcess gameProcess = new GameProcess();
		ResultView resultView= new ResultView();
		resultView.printResult(gameProcess.play(tryCount,cars));
	}
}
