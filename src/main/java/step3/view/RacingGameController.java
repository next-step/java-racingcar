package step3.view;

import static step3.service.RacingGame.*;
import static step3.view.InputView.*;
import static step3.view.ResultView.*;

public class RacingGameController {
	public static void main(String[] args) {
		int carCount = getCarCount();
		int moveCount = getMoveCount();
		int[][] result = race(carCount, moveCount);
		printCurrentPosition(result);
	}
}
