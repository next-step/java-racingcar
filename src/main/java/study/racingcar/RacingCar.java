package study.racingcar;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCar {
    private int distance = 0;
    private final RandomGenerator randomGenerator;

    public RacingCar(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public void move() {
        if (randomGenerator.number() >= 3) {
            distance++;
        }
    }

    public int distance() {
        return distance;
    }
}


