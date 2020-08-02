package step3;

import step3.dto.CarWentResult;

import java.util.Objects;
import java.util.Random;

public class Car {

    private Integer distance;

    private final Integer carNumber;

    private final Random dice = new Random();

    private static final Integer DICE_BOUND = 10;

    private static final Integer GO_ABLE_SCORE = 4;

    public Car(Integer carNumber) {
        this.distance = 0;
        this.carNumber = carNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carNumber.equals(car.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }

    public CarWentResult go() {
        attemptGoing(isAbleToGo(rollDice()));
        return new CarWentResult(this.distance, this.carNumber);
    }

    public Integer getDistance() {
        return this.distance;
    }

    Integer attemptGoing(boolean goingPossibility) {
        return goingPossibility ? ++this.distance : this.distance;
    }

    boolean isAbleToGo(Integer score) {
        return score >= GO_ABLE_SCORE;
    }

    Integer rollDice() {
        return dice.nextInt(DICE_BOUND);
    }
}
