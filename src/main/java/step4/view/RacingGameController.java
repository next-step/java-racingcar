package step4.view;

import static step4.service.RacingGame.*;
import static step4.view.InputView.*;
import static step4.view.ResultView.*;

import step4.domain.RacingHistory;

public class RacingGameController {
	public static void main(String[] args) {
		int carCount = getCarCount();
		int moveCount = getMoveCount();
		RacingHistory result = race(carCount, moveCount);
		printRacingHistory(result);
	}
}
