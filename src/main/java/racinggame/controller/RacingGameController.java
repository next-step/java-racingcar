package racinggame.controller;

import java.util.Scanner;
import racinggame.domain.Cars;
import racinggame.domain.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingGameController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String value = InputView.carCount(scanner);
        int number = InputView.playCount(scanner);

        RacingGame racingGame = new RacingGame(Cars.from(value));

        ResultView.br();
        ResultView.resultSign();
        for (int i = 0; i < number; i++) {
            racingGame.play();
            ResultView.report(racingGame.report());
        }
    }

}
