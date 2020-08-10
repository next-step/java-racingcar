package racingcar.random;

import racingcar.car.Car;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GenerateRandom {
    private static final int RANDOM_BOUND = 10;
    private static final int MINIMUM_VALUE = 3;

    public static int randomForward() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND) > MINIMUM_VALUE ? 1 : 0;
    }

    public static List<Car> moveCarForward(List<Car> cars, int forwardYn) {
        return cars.stream().peek(car -> car.move(forwardYn)).collect(Collectors.toList());
    }
}

