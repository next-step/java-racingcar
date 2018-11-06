package rcgame.domain;


import rcgame.util.NumberGenerator;
import rcgame.util.RandomNumberGenerator;

public class RcCar {
    public static final int MOVE_BOUND_VALUE = 4;
    public static NumberGenerator numberGenerator = new RandomNumberGenerator();

    private int position;

    public RcCar() {
        this.position = 0;
    }

    public int move() {
        if (numberGenerator.getRandomNumber() >= MOVE_BOUND_VALUE) {
            position ++;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }
}
