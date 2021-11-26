package step3;

import java.util.Random;

public class RacingCar {
    private static final int ADVANCE_CONDITION = 4;
    private static final int NAME_LENGTH = 5;

    private RamdomCondition ramdomCondition;

    private int distance = 0;
    private String name;

    public RacingCar() {
        this.ramdomCondition = new RamdomCondition();
    }

    public RacingCar(String name) {
        if(name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public boolean isMove() {
        return this.ramdomCondition.meet(ADVANCE_CONDITION);
    }

    public void move() {
        if (isMove()) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }


}
