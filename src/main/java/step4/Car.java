package step4;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Car {

    private String racer;
    private int position;

    private static final String HYPHEN = "-";
    private static final int MIN_FORWARD_NUMBER = 4;

    public void move(int randomNumber) {
        if (randomNumber >= MIN_FORWARD_NUMBER) {
            this.position++;
        }
    }

    public Car(String racer) {
        this.racer = racer;
    }

    @Override
    public String toString() {
        return String.format("%s:%s", this.racer,
                IntStream.range(0, position)
                        .mapToObj(i -> HYPHEN)
                        .collect(Collectors.joining()));
    }

    public String getRacer() {
        return this.racer;
    }

}