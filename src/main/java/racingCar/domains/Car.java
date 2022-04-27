package racingCar.domains;

import racingCar.interfaces.NumberGeneratorStrategy;

public class Car {
    private int position;
    private NumberGeneratorStrategy strategy;

    public Car() {
        this(new RandomNumberGenerator());
    }

    public Car(NumberGeneratorStrategy strategy) {
        this.position = 0;
        this.strategy = strategy;
    }

    public void move() {
        if (strategy.generate() >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
