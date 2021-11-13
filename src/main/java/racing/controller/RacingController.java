package racing.controller;

import racing.model.RacingResult;
import racing.model.Racing;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.Scanner;

/*
 *
 * RacingGameController
 *
 * @version 1.0.0
 *
 * 2021-11-12
 *
 * Copyright tnals1422
 */
public class RacingController {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String carName = inputView.inputCarName();
        Integer roundCount = inputView.inputRoundCount();

        RacingResult result = new Racing(carName, roundCount).start();

        new OutputView(result).printRacingResult();
    }
}
