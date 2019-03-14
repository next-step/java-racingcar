package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int RANDOM_FROM = 0;
    private static final int RANDOM_TO = 9;
    private static final int MOVE_DIFFICULTY = 4;

    private List<Car> carPositions;

    public RacingGame(int carNumber) {
        carPositions = new ArrayList<>(carNumber);
        for(int i = 0; i < carNumber; i++) {
            carPositions.add(new Car());
        }
    }

    public void gameStart(int inputTimes) {
        System.out.println("실행결과\n");

        for(int i = 0; i < inputTimes; i++) {
            ResultView.viewCars(move(new RandomUtil(RANDOM_FROM, RANDOM_TO)));
        }
    }

    public List<Car> move(RandomUtil randomUtil) {
        for(Car car: carPositions) {
            int randomNumber = randomUtil.randomInt();
            car.moveCarByRandomNumber(MOVE_DIFFICULTY, randomNumber);
        }
        return carPositions;
    }

    public List<Car> getCarPositions() {
        return carPositions;
    }
}
