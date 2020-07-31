package step3;

import java.util.Random;

public class Car {

    private Integer distance;

    private final Random dice = new Random();

    private static final Integer DICE_BOUND = 10;

    private static final Integer GO_ABLE_SCORE = 4;

    public Car() {
        this.distance = 0;
    }

    public Integer go() {
        return attemptGoing(isAbleToGo(rollDice()));
    }

    Integer getDistance() {
        return this.distance;
    }

    Integer attemptGoing(boolean goingPossibility) {
        if(goingPossibility) {
            return ++this.distance;
        }
        return distance;
    }

    boolean isAbleToGo(Integer score) {
        if(score >= GO_ABLE_SCORE) {
            return true;
        }
        return false;
    }

    Integer rollDice() {
        return dice.nextInt(DICE_BOUND);
    }
}
