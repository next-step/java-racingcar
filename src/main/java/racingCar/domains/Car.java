package racingCar.domains;

import racingCar.interfaces.NumberGeneratorStrategy;

public class Car {
    private Name name;
    private int position;
    private NumberGeneratorStrategy strategy;

    public Car(String name) {
        this(name, new RandomNumberGenerator());
    }

    public Car(String name, NumberGeneratorStrategy strategy) {
        this.name = new Name(name);
        this.position = 0;
        this.strategy = strategy;
    }

    public void move() {
        if (strategy.generate() >= 4) {
            position++;
        }
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position;
    }
}
