package racing.model;

import java.util.Random;

public class Car {

    private static final int MAX_BOUND = 10;
    private static final int GO_BEHAVIOR_PIVOT = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private final Random random = new Random();
    private int movingDistance = 0;
    private String name = "";



    public void moveRandom() {
        if (random.nextInt(MAX_BOUND) >= GO_BEHAVIOR_PIVOT) {
            go();
        }
    }

    private void go() {
        movingDistance++;
    }

    public int getMovingDistance() {
        return movingDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 초과가 불가능 합니다.");
        }
        this.name = name;
    }
}
