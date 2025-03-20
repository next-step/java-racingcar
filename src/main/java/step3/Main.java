package step3;


import step3.game.Car;
import step3.game.CarFactory;
import step3.game.GameHistory;
import step3.game.RacingGame;
import step3.random.DefaultRandomStrategy;
import step3.util.InputView;
import step3.util.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        int moveCount = InputView.inputMove();
        List<Car> cars = CarFactory.createCars(carNames);
        RacingGame game = new RacingGame(moveCount, new DefaultRandomStrategy(), cars);
        List<List<GameHistory>> result = game.start();
        OutputView.printResult(result, game.getCurrentWinners());
    }
}