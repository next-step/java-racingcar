package racingcar;

import static java.util.stream.IntStream.range;

import java.util.Random;

import java.util.stream.Collectors;

public class Car {

    private int position;

    public static final int CRITERION_NUMBER = 4;
    public static final int MAX_RANDOM_BOUND = 10;

    public Car(int position) {
        this.position = position;
    }

    public static Car create(int position) {
        return new Car(position);
    }

    public void action(Random random) {
        int commandNumber = random.nextInt(MAX_RANDOM_BOUND);

        if (commandNumber >= CRITERION_NUMBER) {
            forward();
        }
    }

    public void forward() {
        this.position++;
    }

    public String getLocation() {
        return range(0, position)
            .mapToObj(i -> "-")
            .collect(Collectors.joining(""));

    }
}
