package step3;


import step3.game.*;
import step3.random.DefaultRandomStrategy;
import step3.util.InputView;
import step3.util.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        int moveCount = InputView.inputMove();

        List<Car> cars = CarFactory.createCars(carNames);

        RacingGame game = new RacingGame(moveCount, cars);
        List<GameRound> result = game.start(new DefaultRandomStrategy());

        OutputView.printResult(result, Winners.findWinners(result));
    }
}