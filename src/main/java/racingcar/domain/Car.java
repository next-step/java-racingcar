package racingcar.domain;

public class Car {
    private static final int THRESHOLD_TO_MOVE = 4;

    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car move(int randomValue) {
        if (randomValue >= THRESHOLD_TO_MOVE) {
            this.position++;
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public CarDTO toCarDTO() {
        return new CarDTO(name, position);
    }
}