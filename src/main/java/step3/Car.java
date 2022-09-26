package step3;


import java.util.Random;

public class Car {
    public static final int MOVE_NUM = 4;
    public static final int RANDOM_BOUND = 10;
    private int pos;

    public Car() {
        this.pos = 0;
    }

    public int getPos() {
        return pos;
    }

    private void move(int num) {
        if (num >= MOVE_NUM) {
            this.pos++;
        }
    }

    public void play(Random random) {
        move(random.nextInt(RANDOM_BOUND));
    }

}
