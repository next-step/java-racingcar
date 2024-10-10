package step4.view;

import static step4.service.RacingGame.*;
import static step4.view.InputView.*;
import static step4.view.ResultView.*;

import step4.domain.racehistory.RacingHistory;
import step4.domain.view.UserInput;

public class RacingGameController {
	public static void main(String[] args) {
		UserInput userInput = getUserInput();
		RacingHistory result = race(userInput);
		printRacingHistory(result);
	}
}
