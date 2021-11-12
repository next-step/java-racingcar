package study03.controller;

import study03.model.RacingResult;
import study03.model.Racing;
import study03.view.InputView;
import study03.view.OutputView;

import java.util.Scanner;

/*
 *
 * RacingGameController
 *
 * @version 1.0.0
 *
 * 2021-11-10
 *
 * Copyright tnals1422
 */
public class RacingController {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        Integer carCount = inputView.inputCarCount();
        Integer roundCount = inputView.inputRoundCount();

        RacingResult result = new Racing(carCount, roundCount).start();

        new OutputView(result).printGameResult();
    }
}
