package racingcar;

import java.util.*;


public class RacingGame {
    private CarMovableDecider carMovableDecider;
    private List<Car> cars;
    private final int tryNo;
    private int round;
    private RandomUtil randomUtil;

    public RacingGame(String[] carNames, int tryNo, CarMovableDecider carMovableDecider) {
        this.tryNo = tryNo;
        this.round = 0;
        this.carMovableDecider = carMovableDecider;
        cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public RacingResult race() {
        this.round++;
        move();
        return new RacingResult(cars);
    }

    private void move() {
        cars.stream()
                .forEach(car -> car.go(carMovableDecider.movable()));
    }

    public boolean isEnd() {
        if (this.round == tryNo) {
            return true;
        }
        return false;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
