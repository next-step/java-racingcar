package racingcar;

import java.util.Random;

public class Car {
    private Random random;
    private int movement;

    public Car(Random random, int movement) {
        this.random = random;
        this.movement = movement;
    }

    public int getMovement() {
        return this.movement;
    }

    public void increaseMovementRandomly(int range, int cutline, int step) {
        if(this.random.nextInt(range) > cutline) {
            this.movement = this.movement + step;
        }
    }

}
