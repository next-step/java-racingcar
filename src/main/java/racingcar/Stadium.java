package racingcar;

import java.util.List;
import java.util.Random;

public class Stadium {
    private List<Car> cars;
    private int gameCount;

    public Stadium(List<Car> cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    private int drawNumber(){
        return new Random().nextInt(10);
    }
}
