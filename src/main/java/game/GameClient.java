package game;

import game.domain.*;
import game.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static game.view.ResultView.printDistance;
import static game.view.ResultView.printPlainMessage;

public class GameClient {

    private static final String EXECUTION_RESULT = "\n실행 결과";
    private static final String ASK_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        final int bound = 10;
        int gameCount = insertValue(ASK_GAME_COUNT_MESSAGE);
        int carCount = insertValue(ASK_CAR_COUNT_MESSAGE);
        printPlainMessage(EXECUTION_RESULT);
        NumberGenerator generator = new RandomNumberGenerator(bound);
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
