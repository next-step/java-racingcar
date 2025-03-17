package step3;


import step3.game.Car;
import step3.game.CarFactory;
import step3.game.RacingGame;
import step3.random.DefaultRandomStrategy;
import step3.util.InputView;
import step3.util.OutputView;

import java.util.List;

public class Main {
    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String MOVE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    public static void main(String[] args) {
        int carCount = InputView.inputInt(CAR_COUNT_MESSAGE);
        int moveCount = InputView.inputInt(MOVE_COUNT_MESSAGE);
        List<Car> cars = CarFactory.createCars(carCount);
        RacingGame game = new RacingGame(moveCount, new DefaultRandomStrategy(), cars);
        List<List<Integer>> result = game.start();
        OutputView.printResult(result);
    }
}