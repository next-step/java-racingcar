package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private final static String SEPARATOR = ",";
    private final static int RANDOM_NUMBER_RANGE = 10;
    private final static int PIVOT = 4;
    private final static int MOVING = 1;
    private final static int STOP = 0;
    private int time;
    private List<Car> cars;
    private List<String> winners;

    public RacingGame(int time, String input) {
        this.time = time;
        this.cars = initiateCar(input);
    }

    public List<Car> initiateCar(String input) {
        cars = new ArrayList<>();
        for (String carName : input.split(SEPARATOR)) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public int getTime() {
        return time;
    }

    private int getRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_RANGE);
    }

    private int moveCheck() {
        if (getRandomNumber() >= PIVOT) {
            return MOVING;
        }
        return STOP;
    }

    public List<Car> move() {
        for (Car car : cars) {
            car.updatePosition(moveCheck());
        }
        return cars;
    }

    public List<String> winner() {
        winners = new ArrayList<>();
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = sortWinnerPosition(car.getPosition(), winnerPosition);
        }
        return winners = sortWinners(winnerPosition);
    }

    private int sortWinnerPosition(int position, int winnerPosition) {
        if (winnerPosition <= position) {
            return winnerPosition = position;
        }
        return winnerPosition;
    }

    private List<String> sortWinners(int winnerPosition) {
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
