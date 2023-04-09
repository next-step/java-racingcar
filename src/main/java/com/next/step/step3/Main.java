package com.next.step.step3;

import com.next.step.step3.dto.InputDto;
import com.next.step.step3.service.RacingGame;
import com.next.step.step3.validate.InputValidation;
import com.next.step.step3.view.InputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int numOfCars = inputView.numOfCars();
        int numOfAttempts = inputView.numOfAttempts();

        InputValidation inputValidation = new InputValidation();
        inputValidation.validateNotNegative(numOfCars, numOfAttempts);
        inputValidation.validateCanRacingGame(numOfCars, numOfAttempts);

        RacingGame racingGame = new RacingGame();
        racingGame.executeRace(new InputDto(numOfCars, numOfAttempts));
    }
}
