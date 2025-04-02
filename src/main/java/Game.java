import java.util.Scanner;

import domain.Cars;
import domain.RacingGame;
import view.InputView;
import view.OutputView;

public class Game {
    public static void main(String[] args) {
        InputView input = new InputView();
        Cars cars = new Cars(input.submitName());
        RacingGame racingGame = new RacingGame(cars);
        int count = input.submitCount();
        OutputView output = new OutputView(racingGame, count);
        output.printResult();
        racingGame.findWinner();
        output.printWinner(racingGame.winner.toString());
    }
}
