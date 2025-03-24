package step3;

import java.util.Random;
import java.util.function.Function;

public class Car {
    private int position;
    private final Random random;
    private final boolean moveCondition;

    public Car() {
        this.position = 1;
        this.random = new Random();
        this.moveCondition = this.isRandomNumberGreaterThan4();
    }

    public int getPosition () {
        return this.position;
    }

    public void move() {
        if(!isMovable()) return;
        position++;
    }

    private boolean isMovable () {
        return this.moveCondition;
    }

    private boolean isRandomNumberGreaterThan4() {
        return this.random.nextInt(10) >= 4;
    }

    private boolean moveUnconditionally() {
        return true;
    }

}
