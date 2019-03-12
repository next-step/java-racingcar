package racingcar;

public class Car {
    private static final int LOWER_LIMIT_OF_MOVE = 4;
    private int position = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.generateNumber() >= LOWER_LIMIT_OF_MOVE)
            this.position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
