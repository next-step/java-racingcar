package step4;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Car {
    private static final String HYPHEN = "-";
    private static final int MIN_FORWARD_NUMBER = 4;
    private String carName;
    private int position;

    public void move(int randomNumber) {
        if (randomNumber >= MIN_FORWARD_NUMBER) {
            this.position++;
        }
    }

    public Car(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return String.format("%s:%s", this.carName,
                IntStream.range(0, position)
                        .mapToObj(i -> HYPHEN)
                        .collect(Collectors.joining()));
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }

}