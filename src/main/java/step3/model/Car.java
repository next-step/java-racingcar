package step3.model;

import step3.utils.NumberGenerator;
import step3.utils.RandomNumberGenerator;

public class Car {
    private static final int MAX_BOUND = 10;
    private static final int RANDOM_NUMBER_LIMIT = 4;

    private final String name;
    private int distance = 0;
    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator generator) {
        validateCarNameLength(name);

        this.name = name;
        this.numberGenerator = generator;
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
        this.numberGenerator = new RandomNumberGenerator();
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public boolean hasMaxDistance(int maxDistance) {
        return this.distance == maxDistance;
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

    private void validateCarNameLength(String name) {
        if (name.length() > 4) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과 할 수 없습니다.");
        }
    }
}

