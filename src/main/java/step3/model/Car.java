package step3.model;

import step3.utils.NumberGenerator;

public class Car {
    private static final int MAX_BOUND = 10;
    private static final int RANDOM_NUMBER_LIMIT = 4;
    private int distance;
    private final NumberGenerator numberGenerator;

    public Car(int distance, NumberGenerator generator) {
        this.distance = distance;
        this.numberGenerator = generator;
    }

    public int getDistance() {
        return distance;
    }

    public void increaseDistance() {
        if (!availableForward()) {
            return;
        }
        distance++;
    }

    public boolean availableForward() {
        return RANDOM_NUMBER_LIMIT <= numberGenerator.generate(MAX_BOUND);
    }
}
