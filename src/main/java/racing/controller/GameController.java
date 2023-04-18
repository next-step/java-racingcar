package racing.controller;

import racing.domain.Game;
import racing.domain.move.MoveStrategy;
import racing.domain.move.impl.RandomForwardStrategy;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;
import java.util.Scanner;

import static racing.utils.GameCreateUtil.createGameWithStrategy;

public class GameController {
    private final Scanner scanner;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        List<String> nameOfCars = InputView.readNameOfCars(scanner);
        int numOfCycles = InputView.readNumberOfCycles(scanner);
        Game game = setGame(nameOfCars);
        startGame(numOfCycles, game);
    }
    
    private static Game setGame(List<String> nameOfCars) {
        MoveStrategy moveStrategy = new RandomForwardStrategy();
        return createGameWithStrategy(nameOfCars, moveStrategy);
    }

    private static void startGame(int numOfCycles, Game game) {
        ResultView.printStartMessage();
        for (int i = 0; i < numOfCycles; i++) {
            game.progressCycle();
            ResultView.printGameStatus(game);
        }
        ResultView.printWinner(game);
    }
}
