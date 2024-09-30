package racing.domain;

import racing.util.NumberGenerator;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int RANDOM_NUMBER_BOUNDARY = 4;
    private int position;

    private Car(int position) {
        this.position = position;
    }

    public int getCurrentPosition() {
        return position;
    }

    public void move(NumberGenerator numberGenerator) {
        if (isMovable(numberGenerator)) {
            position++;
        }
    }

    private boolean isMovable(NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.generate();
        return randomNumber >= RANDOM_NUMBER_BOUNDARY;
    }

    public static Car create() {
        return new Car(DEFAULT_POSITION);
    }
}
