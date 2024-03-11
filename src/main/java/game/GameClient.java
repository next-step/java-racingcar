package game;

import game.domain.*;
import game.util.ResultView;

import java.util.ArrayList;
import java.util.List;

import static game.domain.Constant.BOUND;
import static game.domain.Constant.EXECUTION_RESULT;

public class GameClient {

    public static void main(String[] args) {
        GameInput input = new GameInput();
        int gameCount = input.insertGameCount();
        int carCount = input.insertCarCount();
        ResultView.printPlainMessage(EXECUTION_RESULT);
        NumberGenerator generator = new RandomNumberGenerator(BOUND);
        List<Car> cars = generateCars(carCount);
        playGamesAndPrintResult(gameCount, generator, cars);
    }

    private static void playGamesAndPrintResult(int gameCount, NumberGenerator generator, List<Car> cars) {
        Game game = new Game(generator, cars);
        game.printResult();
        for (int i = 1; i < gameCount; i++) {
            game.play();
            game.printResult();
        }
    }

    private static List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
