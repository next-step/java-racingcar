package step3;

import step3.domain.CarNumber;
import step3.domain.RacingCarGame;
import step3.domain.TryNumber;
import step3.utils.Message;
import step3.view.InputView;
import step3.view.ResultView;

public class RacingCarGameClient {
	public static void main(String[] args) {
		CarNumber carNumber = new CarNumber(InputView.waiteInputCarCount());
		TryNumber tryNumber = new TryNumber(InputView.waiteInputTryCount());

		RacingCarGame game = new RacingCarGame(carNumber, tryNumber);

		System.out.println(Message.PRINT_RESULT);
		while (game.playing()) {
			game.play();
			ResultView.printResult(game.getCars());
		}
	}
}
