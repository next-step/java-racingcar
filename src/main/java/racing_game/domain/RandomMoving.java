package racing_game.domain;

import java.util.Random;
import racing_game.core.Positive;

public class RandomMoving implements Moving {

    private final Positive bound;
    private final Positive condition;
    private final Random random;
    private final Positive distance;

    public RandomMoving(int bound, int condition) {
        this.random = new Random();
        this.distance = Positive.zero();
        this.bound = Positive.of(bound);
        this.condition = Positive.of(condition);
    }

    @Override
    public void move() {
        if (canMove()) {
            distance.addOne();
        }
    }

    @Override
    public Positive getDistance() {
        return Positive.copy(distance);
    }

    private boolean canMove() {
        return random.nextInt(bound.toInt()) >= condition.toInt();
    }
}
