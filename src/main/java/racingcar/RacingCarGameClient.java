package racingcar;

import racingcar.domain.Names;
import racingcar.domain.RacingCarGame;
import racingcar.domain.TryNumber;
import racingcar.utils.Message;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGameClient {
	public static void main(String[] args) {
		Names names = new Names(InputView.waiteInputCarNames());
		TryNumber tryNumber = new TryNumber(InputView.waiteInputTryCount());

		RacingCarGame game = new RacingCarGame(names, tryNumber);

		System.out.println(Message.PRINT_RESULT);
		while (game.playing()) {
			game.play();
			ResultView.printResult(game.getCars());
		}
		ResultView.printWinners(game.getCars());
	}
}
