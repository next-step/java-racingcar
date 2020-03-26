package study;

import java.util.Random;

public class Car {

    private final int RANDOM_BOUND = 10;
    private final int BASE_POINT = 4;

    private int position;
    private String name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        Random random = new Random();
        int ranCount = random.nextInt(RANDOM_BOUND);
        if (ranCount >= BASE_POINT) {
            this.position++;
        }
    }

}
