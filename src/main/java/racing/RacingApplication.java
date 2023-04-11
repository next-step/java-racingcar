package racing;

import racing.domain.RacingGame;
import racing.strategy.MoveStrategy;
import racing.strategy.impl.RandomForwardStrategy;
import racing.view.ResultView;

import java.util.Scanner;

import static racing.view.InputView.readNumberOfCars;
import static racing.view.InputView.readNumberOfCycles;

public class RacingApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numOfCars = readNumberOfCars(scanner);
        int numOfCycles = readNumberOfCycles(scanner);

        RacingGame game = setGame(numOfCars);
        startGame(numOfCycles, game);
    }

    private static RacingGame setGame(int numOfCars) {
        RacingGame game = new RacingGame(numOfCars);
        MoveStrategy moveStrategy = new RandomForwardStrategy();
        game.setMoveStrategyOfCars(moveStrategy);
        return game;
    }

    private static void startGame(int numOfCycles, RacingGame game) {
        ResultView.printStartMessage();
        for (int i = 0; i < numOfCycles; i++) {
            game.progressCycle();
            ResultView.printGameStatus(game);
        }
    }


}
