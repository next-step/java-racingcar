package com.nextstep.racingcargame.core;

import static com.nextstep.racingcargame.view.QuestionView.clientQuestion;
import static com.nextstep.racingcargame.view.ResultView.createNewLine;
import static com.nextstep.racingcargame.view.ResultView.printAllCarCurrentDistance;
import static com.nextstep.racingcargame.view.ResultView.printResultMsg;
import static com.nextstep.racingcargame.view.ResultView.printSource;
import static com.nextstep.racingcargame.view.ResultView.printWinners;

public class RacingGame {

    public static void progressRacing() {

        ClientResponse clientResponse = clientQuestion();

        Cars cars = clientResponse.createCarsByUserCarNumberInput();

        startGame(clientResponse, cars);
    }


    private static void startGame(ClientResponse clientResponse, Cars cars) {

        createNewLine();
        printResultMsg();

        for (int turn = 0; turn < clientResponse.getNumberOfTries(); turn++) {
            cars.moveCars();
            printAllCarCurrentDistance(cars);
            createNewLine();
        }

        printWinners(cars);
    }

    public static void main(String[] args) {
        progressRacing();
    }
}
