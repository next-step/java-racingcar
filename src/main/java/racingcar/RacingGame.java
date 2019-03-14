package racingcar;

import sun.awt.ConstrainableGraphics;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int RANDOM_FROM = 0;
    private static final int RANDOM_TO = 9;
    private static final int MOVE_DIFFICULTY = 4;

    private List<Car> cars;

    public RacingGame(String[] carNames) {
        int carNumber = carNames.length;

        cars = new ArrayList<>(carNumber);
        for(int i = 0; i < carNumber; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    public void gameStart(int inputTimes) {
        System.out.println("\n실행결과");

        for(int i = 0; i < inputTimes; i++) {
            ResultView.viewCars(move(new RandomUtil(RANDOM_FROM, RANDOM_TO)));
        }

        GameResult gameResult = new GameResult();
        ResultView.viewWinner(gameResult.getWinner(cars));
    }

    public List<Car> move(RandomUtil randomUtil) {
        for(Car car: cars) {
            int randomNumber = randomUtil.randomInt();
            car.moveCarByRandomNumber(MOVE_DIFFICULTY, randomNumber);
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

}
