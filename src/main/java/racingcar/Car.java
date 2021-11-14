package racingcar;

import static java.util.stream.IntStream.range;
import static racingcar.utils.StringLengthValidator.*;

import java.util.Random;
import java.util.stream.Collectors;

public class Car {

    private final String name;
    private int position;

    public static final int CRITERION_NUMBER = 4;
    public static final int CAR_NAME_LENGTH_LIMIT = 5;
    public static final int MAX_RANDOM_BOUND = 10;

    private Car(String name, int position) {
        this.name = validUnderMaxLength(name, CAR_NAME_LENGTH_LIMIT);
        this.position = position;
    }

    public static Car create(String name) {
        return new Car(name, 0);
    }

    public static Car create(String name, int position) {
        return new Car(name, position);
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

    public String getName() {
        return name;
    }
}
