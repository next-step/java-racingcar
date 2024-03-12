package game;

import game.domain.*;
import game.view.InputView;
import game.view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static game.domain.Constant.*;
import static game.view.ResultView.printDistance;
import static game.view.ResultView.printPlainMessage;

public class GameClient {

    public static void main(String[] args) {
        int gameCount = insertValue(ASK_GAME_COUNT_MESSAGE);
        int carCount = insertValue(ASK_CAR_COUNT_MESSAGE);
        printPlainMessage(EXECUTION_RESULT);
        NumberGenerator generator = new RandomNumberGenerator(BOUND);
        List<Car> cars = generateCars(carCount);
        playGamesAndPrintResult(gameCount, generator, cars);
    }

    private static int insertValue(String message) {
        printPlainMessage(message);
        return InputView.insertInt();
    }

    private static void playGamesAndPrintResult(int gameCount, NumberGenerator generator, List<Car> cars) {
        Game game = new Game(generator, cars);
        printDistances(game);
        for (int i = 1; i < gameCount; i++) {
            game.play();
            printDistances(game);
        }
    }

    private static void printDistances(Game game){
        printDistance(game.getDistances());
        printPlainMessage("");
    }

    private static List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
