package step4.view;

import static step4.service.RacingGame.*;
import static step4.view.InputView.*;
import static step4.view.ResultView.*;

import step3.exception.RaceParamUnvalidException;
import step4.domain.car.CarList;
import step4.domain.view.UserInput;

public class RacingGameController {
	public static void main(String[] args) {
		try {
			UserInput userInput = getUserInput();
			CarList carList = race(userInput);
			printRacingHistory(carList);
		} catch (RaceParamUnvalidException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("알 수 없는 오류로 실패했습니다.");
		}
	}
}
