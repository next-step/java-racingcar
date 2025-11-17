package racinggame.domain;

import java.util.Random;

public class Car {
    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;

    private final Name name;
    private int position = 0;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this(new Name(name), position);
    }

    public Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    public void move() {
        Random random = new Random();
        int randomNo = random.nextInt(MAX_BOUND);
        if (randomNo >= FORWARD_NUM)
            this.position++;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public int max(int maxPosition) {
        return Math.max(this.position, maxPosition);
    }


}
