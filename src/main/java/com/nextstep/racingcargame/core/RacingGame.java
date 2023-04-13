package com.nextstep.racingcargame.core;

import static com.nextstep.racingcargame.view.ClientView.createNewLine;
import static com.nextstep.racingcargame.view.ClientView.printSource;
import static com.nextstep.racingcargame.view.QuestionView.clientQuestion;

public class RacingGame {

    private static final String RESULT_MSG = "실행 결과";

    private static final String ADDITIONAL_WINNER_MSG = "가 최종 우승했습니다.";

    public static void progressRacing() {

        ClientResponse clientResponse = clientQuestion();

        Cars cars = clientResponse.createCarsByUserCarNumberInput();

        startGame(clientResponse, cars);
    }


    private static void startGame(ClientResponse clientResponse, Cars cars) {

        createNewLine();
        printSource(RESULT_MSG);

        for (int turn = 0; turn < clientResponse.getNumberOfTries(); turn++) {
            cars.moveCars();
            cars.disPlayCarsTravelDistance();
            createNewLine();
        }

        printSource(cars.joinedWinnerNames() + ADDITIONAL_WINNER_MSG);
    }

    public static void main(String[] args) {
        progressRacing();
    }
}
