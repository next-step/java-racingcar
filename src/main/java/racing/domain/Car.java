package racing.domain;

import racing.util.NumberGenerator;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int RANDOM_NUMBER_BOUNDARY = 4;
    private int position;
    private final NumberGenerator numberGenerator;

    private Car(int position, NumberGenerator numberGenerator) {
        this.position = position;
        this.numberGenerator = numberGenerator;
    }

    public int getCurrentPosition() {
        return position;
    }

    public void move() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        int randomNumber = numberGenerator.generate();
        return randomNumber >= RANDOM_NUMBER_BOUNDARY;
    }

    public static Car create(NumberGenerator numberGenerator) {
        return new Car(DEFAULT_POSITION, numberGenerator);
    }
}
