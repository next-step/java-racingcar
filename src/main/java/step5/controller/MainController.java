package step5.controller;

import step5.domain.RacingGame;
import step5.dto.InputDto;
import step5.view.InputView;
import step5.view.ResultView;

public class MainController {
    public static void main(String[] args) {
        try {
            InputDto input = InputView.input();
            RacingGame racingGame = new RacingGame(input);
            racingGame.start();

            String winner = racingGame.findWinner();
            ResultView.printWinner(winner);
        } catch (IllegalArgumentException e) {
            System.out.println("에러는 -> " + e);
        }
    }
}
