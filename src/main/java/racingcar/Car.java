package racingcar;

import racingcar.number_generator.NumberGenerator;
import racingcar.number_generator.RandomNumberGenerator;

public class Car {

    private static final int FORWARD_THRESHOLD = 4;

    private final CarName name;
    private final NumberGenerator numberGenerator;
    private int distance;

    Car(String name, NumberGenerator numberGenerator) {
        this.name = new CarName(name);
        this.numberGenerator = numberGenerator;
    }

    public Car(String name) {
        this(name, new RandomNumberGenerator());
    }

    public String getName() {
        return name.getCarName();
    }

    public int getDistance() {
        return distance;
    }

    void forward() {
        distance++;
    }

    public void progress() {
        if (canMove()) {
            forward();
        }
    }

    private boolean canMove() {
        return numberGenerator.generate() >= FORWARD_THRESHOLD;
    }

    public boolean isSameDistance(int maxDistance) {
        return this.distance == maxDistance;
    }
}
