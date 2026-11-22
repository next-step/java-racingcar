package racinggame.winner;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private final RacingCount count;

    public RacingGame(List<Car> cars, RacingCount count) {
        this.cars = cars;
        this.count = count;
    }

    public void race(int randomNo) {
        count.decrease();

        for (Car car : cars) {
            car.move(randomNo);
        }
    }

    public boolean isFinish() {
        return count.isZero();
    }
}
