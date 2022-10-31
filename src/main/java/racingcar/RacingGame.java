package racingcar;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private static final Random random = new Random();

    private static final int RANDOM_BOUND = 10;

    public List<Car> carMoveRandom(List<Car> before) {
        return before.stream().map(car -> car.move(getRandomNumber())).collect(Collectors.toList());
    }

    protected int getRandomNumber() {
        return random.nextInt(RANDOM_BOUND);
    }

}
