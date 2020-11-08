package step4;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Car {
    String racer;
    int position;
    private static final String HYPHEN = "-";

    public void move() {
        position++;
    }

    public Car(String racer) {
        this.racer = racer;
    }

    @Override
    public String toString() {
        return IntStream.range(0, position)
                .mapToObj(i -> HYPHEN)
                .collect(Collectors.joining());
    }

    public String getRacer() {
        return this.racer;
    }
}
