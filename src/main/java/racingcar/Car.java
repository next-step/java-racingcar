package racingcar;

import static java.util.stream.IntStream.range;

import java.util.Random;
import java.util.stream.Collectors;

public class Car {

    private int position = 0;

    public static final int MAX_RANDOM_BOUND = 10;

    public void action(Random random) {
        Command.of(random.nextInt(MAX_RANDOM_BOUND)).accept(this);
    }

    public void forward() {
        this.position++;
    }

    public void nonForward() {
        // Non Forward
    }

    public String getLocation() {
        return range(0, position)
            .mapToObj(i -> "-")
            .collect(Collectors.joining(""));

    }
}
