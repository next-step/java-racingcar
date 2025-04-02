import java.util.Scanner;

import domain.Cars;
import domain.RacingGame;
import view.InputView;
import view.OutputView;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView input = new InputView(scanner);
        Cars cars = new Cars(input.submitName());
        RacingGame racingGame = new RacingGame(cars);
        int count = input.submitCount();
        OutputView output = new OutputView(racingGame, count);
        output.printResult();
        racingGame.findWinner();
        output.printWinner(racingGame.winner.toString());
    }
}
