package com.nextstep.racingcargame.core;

import static com.nextstep.racingcargame.view.ClientInputView.getClientInputByCarAndTryCounts;
import static com.nextstep.racingcargame.view.DefaultClientView.createNewLine;

public class InitializeRacingGame {

    private static final String RESULT_MSG = "실행 결과";

    public static void progressRacing() {

        ClientInput clientInput = addressQuestion();

        Cars cars = clientInput.createCarsByUserCarNumberInput();

        startGame(clientInput, cars);
    }


    private static ClientInput addressQuestion() {
        return getClientInputByCarAndTryCounts();
    }

    private static void startGame(ClientInput clientInput, Cars cars) {

        System.out.println(RESULT_MSG);

        for (int turn = 0; turn < clientInput.getNumberOfTries(); turn++) {
            cars.moveCars();
            cars.disPlayCarsTravelDistance();
            createNewLine();
        }
    }

    public static void main(String[] args) {
        progressRacing();
    }
}
