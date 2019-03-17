package racingcar;

public class Car {
    private static final int THRESHOLD_TO_MOVE = 4;

    private String name;
    private int position;

    Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    Car(String name) {
        this(name, 0);
    }

    Car move(int randomValue) {
        if (randomValue >= THRESHOLD_TO_MOVE) {
            this.position++;
        }
        return this;
    }

    CarDTO toCarDTO() {
        return new CarDTO(name, position);
    }
}