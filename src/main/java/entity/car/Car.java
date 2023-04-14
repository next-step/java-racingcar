package entity.car;

import entity.NumberGenerator;

import java.util.Random;

public class Car {

    private static final Random RANDOM_DICE = new Random();
    private static final int LEAST_RANDOM_VALUE = 4;
    private CarPosition position;
    private CarName name;

    public Car(String name) {
        this.position = new CarPosition(0);
        this.name = CarName.from(name);
    }

    public void moveCar(NumberGenerator numberGenerator) {
        final int number = numberGenerator.generate();
        if (number >= LEAST_RANDOM_VALUE) {
            this.position = position.move();
        }
    }

    public String getNameValue() {
        return name.getName();
    }

    public int getPositionValue() {
        return position.getPositionValue();
    }

    public int moveOrNot() {
        return RANDOM_DICE.nextInt(10);
    }
}
