package com.nextstep.racingcargame.core;

import static com.nextstep.racingcargame.core.ClientInput.getClientInputByCarAndTryCounts;
import static com.nextstep.racingcargame.view.ClientView.createNewLine;
import static com.nextstep.racingcargame.view.ClientView.printSource;

public class InitializeRacingGame {

    private static final String RESULT_MSG = "실행 결과";

    private static final String ADDITIONAL_WINNER_MSG = "가 최종 우승했습니다.";

    public static void progressRacing() {

        ClientInput clientInput = addressQuestion();

        Cars cars = clientInput.createCarsByUserCarNumberInput();

        startGame(clientInput, cars);
    }

    private static ClientInput addressQuestion() {
        return getClientInputByCarAndTryCounts();
    }

    private static void startGame(ClientInput clientInput, Cars cars) {

        createNewLine();
        printSource(RESULT_MSG);

        for (int turn = 0; turn < clientInput.getNumberOfTries(); turn++) {
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
