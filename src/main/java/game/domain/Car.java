package game.domain;

import game.util.NumberGenerator;

public class Car {
    private final CarMovePolicy carMovePolicy;
    private final NumberGenerator numberGenerator;

    private int position = 0;

    public Car(NumberGenerator numberGenerator) {
        this(new StandardCarMovePolicy(), numberGenerator);
    }

    public Car(CarMovePolicy carMovePolicy, NumberGenerator numberGenerator) {
        this.carMovePolicy = carMovePolicy;
        this.numberGenerator = numberGenerator;
    }

    public void drive() {
        if (carMovePolicy.isMovable(numberGenerator.generate())) {
            position++;
        }
    }

    public int position() {
        return position;
    }
}