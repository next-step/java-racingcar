package step5.view;

import static step5.service.RacingGame.*;
import static step5.view.InputView.*;
import static step5.view.ResultView.*;

import step5.domain.race.RaceHistory;
import step5.dto.UserInput;
import step5.exception.CarNameLengthUnvalidException;
import step5.exception.CarNameNestedException;
import step5.exception.RaceParamUnvalidException;

public class RacingGameController {
	public static void main(String[] args) {
		try {
			UserInput userInput = getUserInput();
			RaceHistory raceResult = race(userInput);
			printRacingHistory(raceResult);
		} catch (CarNameLengthUnvalidException | RaceParamUnvalidException | CarNameNestedException e) {
			handleUnexpectedParams(e);
		}
	}
}
