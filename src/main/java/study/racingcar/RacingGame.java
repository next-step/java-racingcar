package study.racingcar;

import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final Random RANDOM = new Random();
    private static final int BOUND_NUMBER = 10;
    public static void gameStart(List<Car> carList, int countOfGames) {

        ResultView.startGame();

        for(int i = 0; i < countOfGames; i++) {
            moveCar(carList);
        }
    }

    private static void moveCar(List<Car> cars) {

        for(Car car : cars) {
            car.move(generateRandomNumber());

            ResultView.resultGame(car.getPosition());
        }

        ResultView.emptyLine();
    }

    public static int generateRandomNumber() {
        return RANDOM.nextInt(BOUND_NUMBER);
    }
}
