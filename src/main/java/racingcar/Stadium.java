package racingcar;

import java.util.List;

public class Stadium {
    private List<Car> cars;
    private int gameCount;

    public Stadium(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }
}
