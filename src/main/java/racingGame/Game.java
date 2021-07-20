package racingGame;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<Car> cars = new ArrayList<>();
    private final int repeatCount;

    public Game(int carSize, int repeatCount) {
        for (int i = 0; i < carSize; i++) {
            cars.add(new Car());
        }
        this.repeatCount = repeatCount;
    }

    public int getCarSize() {
        return cars.size();
    }

    public int getRepeatCount() {
        return repeatCount;
    }
}
