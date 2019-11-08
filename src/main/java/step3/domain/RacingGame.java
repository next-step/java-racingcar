package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final static String SEPARATOR = ",";
    private final static int MAX_WINNER_POSITION = 0;
    private List<Car> cars;
    private int time;

    public RacingGame(int time, String input) {
        this.time = time;
        this.cars = initiateCar(input);
        execute(time);
    }

    public List<Car> initiateCar(String input) {
        cars = new ArrayList<>();
        for (String carName : input.split(SEPARATOR)) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    public Integer calculateWinnerPosition() {
        int winnerPosition = MAX_WINNER_POSITION;
        for (Car car : cars) {
            winnerPosition = Math.max(car.currentPosition(), winnerPosition);
        }
        return winnerPosition;
    }

    private void execute(int time) {
        for (int i = 0; i < time; i++) {
            move();
        }
    }

    private void move() {
        for (Car car : cars) {
            car.updatePosition();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTime() {
        return time;
    }
}