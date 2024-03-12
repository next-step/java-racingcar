package domain;

import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private int moveCount;

    public RacingGame(List<Car> cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public void play() {
        while (moveCount-- > 0) {
            move();
            ResultView.print(cars);
        }
    }

    private void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> winner() {
        Position longest = getLongestPosition();
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            addIfLongestPosition(car, longest, result);
        }
        return result;
    }

    private void addIfLongestPosition(Car car, Position longest, List<Car> result) {
        if (longest.compareTo(car.position()) == 0) {
            result.add(car);
        }
    }

    private Position getLongestPosition() {
        Position position = new Position();
        for (Car car : cars) {
            position = getLongestPosition(car, position);
        }
        return position;
    }

    private Position getLongestPosition(Car car, Position position) {
        if (position.compareTo(car.position()) < 0) {
            position = new Position(car.position().getValue());
        }
        return position;
    }
}
