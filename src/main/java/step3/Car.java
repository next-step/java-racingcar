package step3;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private int position;
    private static final int BOUND = 9;
    private static final int FOUR = 4;
    private final Random random = new Random();

    public void move() {
        if (this.random() >= FOUR) {
            this.position++;
        }
    }

    @Override
    public String toString() {
        return IntStream.range(0, position)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    private int random() {
        return random.nextInt(BOUND);
    }
}
