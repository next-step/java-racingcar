package carRacing.domain;

import java.util.Random;

public class Car {
    private int score;

    public Car() {
        this.score = 0;
    }

    public Car(int score) {
        this.score = score;
    }

    public Car(Car car) {
        this(car.score);
    }

    public Car raceOrStay(Car car) {
        Car carAfterAction = new Car(car);
        Random random = Game.random;
        if (random.nextInt(10) >= 4) {
            carAfterAction.score += 1;
        }
        return carAfterAction;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        StringBuilder trace = new StringBuilder("\uD83D\uDE98");
        for (int count = 0; count < this.score; count++) {
            trace.append("-");
        }
        return trace.toString();
    }
}
