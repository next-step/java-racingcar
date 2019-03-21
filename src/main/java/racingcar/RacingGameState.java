package racingcar;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameState {

    private List<Car> cars;
    private int tryNo;
    private int round;

    public RacingGameState(String[] carNames, int tryNo) {
        cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        this.tryNo = tryNo;
        this.round = 0;

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

    public int getTryNo() {
        return tryNo;
    }

    public int getRound() {
        return round;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }
}
