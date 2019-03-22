package racingcar.domain;


import racingcar.domain.Car;
import racingcar.domain.CarMovableDecider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameState {
    private static final int READY_ROUND = 0;
    private List<Car> cars;
    private int tryNo;
    private int round;

    public RacingGameState(String[] carNames, int tryNo) {
        cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        this.tryNo = tryNo;
        this.round = READY_ROUND;

    }

    public void move(CarMovableDecider carMovableDecider) {
        cars.stream()
                .forEach(car -> {
                    if (carMovableDecider.movable()) {
                        car.go();
                    }
                });
    }

    public void nextRound() {
        round++;
    }

    public boolean isEnd() {
        if(this.round == this.tryNo) {
            return true;
        }
        return false;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }
}
