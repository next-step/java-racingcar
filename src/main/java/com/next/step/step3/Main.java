package com.next.step.step3;

import com.next.step.step3.dto.InputDto;
import com.next.step.step3.service.RacingGame;
import com.next.step.step3.validate.InputValidation;
import com.next.step.step3.view.InputView;
import com.next.step.step3.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView(new InputValidation());
        List<String> carNames = inputView.carsName();
        int numOfAttempts = inputView.numOfAttempts();

        RacingGame racingGame = new RacingGame();
        List<String> winnerNames = racingGame.executeRace(new InputDto(carNames, numOfAttempts));

        ResultView resultView = new ResultView();
        resultView.showWinnerNames(winnerNames);
    }
}
