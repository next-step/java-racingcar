package racing;

import racing.domain.RacingGame;
import racing.strategy.MoveStrategy;
import racing.strategy.impl.RandomForwardStrategy;
import racing.view.ResultView;

import java.util.List;
import java.util.Scanner;

import static racing.utils.GameCreateUtil.createGameWithStrategy;
import static racing.view.InputView.readNameOfCars;
import static racing.view.InputView.readNumberOfCycles;

public class RacingApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> nameOfCars = readNameOfCars(scanner);
        int numOfCycles = readNumberOfCycles(scanner);

        RacingGame game = setGame(nameOfCars);
        startGame(numOfCycles, game);
    }

    private static RacingGame setGame(List<String> nameOfCars) {
        MoveStrategy moveStrategy = new RandomForwardStrategy();
        return createGameWithStrategy(nameOfCars, moveStrategy);
    }

    private static void startGame(int numOfCycles, RacingGame game) {
        ResultView.printStartMessage();
        for (int i = 0; i < numOfCycles; i++) {
            game.progressCycle();
            ResultView.printGameStatus(game);
        }
        ResultView.printWinner(game);
    }
}
