package study.racingcar.domain;

import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> cars;
    private MovableDistance movableDistance;

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

    public List<Car> getCars() {
        return cars;
    }

    private void decreaseTime() {
        time--;
    }

    public boolean isMovable() {
        return time != 0;
    }

    public boolean isFinished() {
        return !isMovable();
    }
}
