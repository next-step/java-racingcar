package step4.view;

import static step4.service.RacingGame.*;
import static step4.view.InputView.*;
import static step4.view.ResultView.*;

import step4.domain.race.RaceResult;
import step4.dto.UserInput;
import step4.exception.CarNameLengthUnvalidException;
import step4.exception.CarNameNestedException;
import step4.exception.RaceParamUnvalidException;

public class RacingGameController {
	public static void main(String[] args) {
		try {
			UserInput userInput = getUserInput();
			RaceResult raceResult = race(userInput);
			printRacingHistory(raceResult);
		} catch (CarNameLengthUnvalidException | RaceParamUnvalidException | CarNameNestedException e) {
			handleUnexpectedParams(e);
		}
	}
}
