package step3;

import java.util.Random;

public class RacingCar {
    private static final int RANDOM_NUMBER_BOUND = 10;

    //private Random random;
    private RandomValue randomValue;

    private int distance = 0;
    private Name name;

    public RacingCar() {
        //this.random = new Random();
        this.randomValue = new RandomValue(new Random().nextInt(RANDOM_NUMBER_BOUND));
        //this.ramdomCondition = new RamdomCondition();
    }

    public RacingCar(String name) {
        this();
        this.name = new Name(name);
    }

    public boolean isMove(RamdomCondition ramdomCondition) {
        return ramdomCondition.meet(this.randomValue);
    }

    public void move(RamdomCondition ramdomCondition) {
        if (isMove(ramdomCondition)) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

    public Name getName() {
        return this.name;
    }


}
