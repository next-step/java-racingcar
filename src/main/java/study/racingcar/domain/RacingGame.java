package study.racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private int time;
    private List<Car> cars;
    private MovableDistance movableDistance;

    // todo racing game data 가 과연 필요할까?
    public RacingGame(RacingGameData racingGameData,
                      MovableDistance movableDistance) {
        this.cars = racingGameData.getCars();
        this.time = racingGameData.getTime();
        this.movableDistance = movableDistance;
    }

    public void move() {
        if (!isMovable()) {
            return;
        }
        decreaseTime();
        for (Car car : cars) {
            car.addPosition(movableDistance.getDistance());
        }
    }

    public List<Car> getWinner() {
        if (isMovable()) {
            return new ArrayList<>();
        }

        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isPositionEqualTo(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return Collections
                .max(cars, Comparator.comparing(Car::getPosition))
                .getPosition();
    }

    public List<Car> getCars() {
        return cars;
    }

    private void decreaseTime() {
        time--;
    }

    public boolean isMovable() {
        return time != 0;
    }
}
