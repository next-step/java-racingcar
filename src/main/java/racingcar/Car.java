package racingcar;


import java.util.Random;

public class Car {
    private static final RandomBool RANDOM_BOOL = new RandomBool();
    private int position = 0;

    public void tryMove() {
        move(RANDOM_BOOL.next());
    }

    public void move(boolean movable) {
        if(movable){
            increasePosition();
        }
    }

    public int getPosition() {
        return this.position;
    }

    private void increasePosition() {
        this.position += 1;
    }
}
