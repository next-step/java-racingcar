package study.racingcar;

import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final Random RANDOM = new Random();
    private static final int BOUND_NUMBER = 10;
    private static final int MOVE_CONDITION = 4;
    private static final String MOVE_MARK = "-";

    public static void gameStart(List<Car> carList, int countOfGames) {

        ResultView.startGame();

        for(int i = 0; i < countOfGames; i++) {
            moveCar(carList);
        }
    }

    private static void moveCar(List<Car> cars) {

        for(Car car : cars) {
            move(generateRandomNumber(), car);

            ResultView.resultGame(car.getPosition());
        }

        ResultView.emptyLine();
    }

    public static int generateRandomNumber() {
        return RANDOM.nextInt(BOUND_NUMBER);
    }

    public static void move(int randomNum, Car car) {
        if (isMove(randomNum)) {
            car.setPosition(car.getPosition() + MOVE_MARK);
        }
    }

    private static boolean isMove(int randomNum) {
        return randomNum >= MOVE_CONDITION;
    }
}
