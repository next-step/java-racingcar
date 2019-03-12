package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int RANDOM_RANGE = 10;
    private Random random = new Random();
    private List<Car> carPositions;

    public RacingGame(int carNumber) {
        carPositions = new ArrayList<>(carNumber);
        for(int i = 0; i < carNumber; i++) {
            carPositions.add(new Car());
        }
    }

    public List<Car> move() {

        for(int i = 0; i < carPositions.size(); i++) {
            carPositions.get(i).moveCar(random.nextInt(RANDOM_RANGE));
        }

        return carPositions;
    }
}
