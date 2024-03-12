package game;

import game.domain.*;
import game.view.InputView;

import java.util.ArrayList;
import java.util.List;

import static game.view.ResultView.*;

public class GameClient {

    private static final String EXECUTION_RESULT = "\n실행 결과";
    private static final String ASK_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        final int bound = 10;
        String[] names = insertNames();
        int carCount = names.length;
        int gameCount = insertCount();
        printPlainMessage(EXECUTION_RESULT);
        NumberGenerator generator = new RandomNumberGenerator(bound);
        List<Car> cars = generateCars(carCount, names);
        playGamesAndPrintResult(gameCount, generator, cars);
    }

    private static int insertCount() {
        printPlainMessage(GameClient.ASK_GAME_COUNT_MESSAGE);
        return InputView.insertInt();
    }

    private static String[] insertNames(){
        printPlainMessage(GameClient.ASK_CAR_NAME_MESSAGE);
        String names = InputView.insertValue();
        return names.split(",");
    }

    private static void playGamesAndPrintResult(int gameCount, NumberGenerator generator, List<Car> cars) {
        if(gameCount <= 0) return;
        Game game = new Game(generator, cars);
        printDistances(game);
        for (int i = 1; i < gameCount; i++) {
            game.play();
            printDistances(game);
        }
    }

    private static void printDistances(Game game){
        printCars(game.getCars());
        printPlainMessage("");
    }

    private static List<Car> generateCars(int carCount, String[] names) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(names[i]));
        }
        return cars;
    }
}
