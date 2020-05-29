package step5;

import step5.domain.RacingGame;
import step5.view.InputView;

/*
 * Java Racing Game
 * MainApplication
 * ver. 1.0
 * 2020.05.27
 * Copyright ...
 */
public class MainApplication {

    public static void main(String[] args) {

        // set new car
        String[] carsNames = InputView.setCarsNames();

        // set play times.
        int playTimes = InputView.setPlayTimes();

        RacingGame racingGame = new RacingGame(carsNames, playTimes);

        racingGame.play();

    }


}
