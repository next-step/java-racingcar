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
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    public static void main(String[] args) {
        String carNames = InputView.inputString(CAR_NAME_MESSAGE);
        int moveCount = InputView.inputInt(MOVE_COUNT_MESSAGE);
        List<Car> cars = CarFactory.createCars(carNames);
        RacingGame game = new RacingGame(moveCount, new DefaultRandomStrategy(), cars);
        List<List<GameHistory>> result = game.start();
        OutputView.printResult(result, game.getCurrentWinners());
    }
}