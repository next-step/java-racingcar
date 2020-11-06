package step3;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private int position;
    private static final int BOUND = 9;
    private static final int MIN_FORWARD_NUMBER = 4;
    private static final String HYPHEN = "-";
    private final Random random = new Random();

    public void move(int randomNumber) {
        if (randomNumber >= MIN_FORWARD_NUMBER) {
            this.position++;
        }
    }

    @Override
    public String toString() {
        return IntStream.range(0, position)
                .mapToObj(i -> HYPHEN)
                .collect(Collectors.joining());
    }

    public int random() {
        return random.nextInt(BOUND);
    }

    public int getPosition() {
        return this.position;
    }
}
