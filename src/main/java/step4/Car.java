package step4;

import java.util.Random;

public class Car {
    private int position;
    private Random random;
    public String name;

    public Car(Random random) {
        this.position = 1;
        this.random = random;
        this.name = name;
    }

    public int getPosition () {
        return this.position;
    }

    private boolean isMovable () {
        return this.random.nextInt(10) >= 4;
    }

    public void move() {
        if(!isMovable()) return;
        position++;
    }
    public String draw(int position) {
        return "-".repeat(this.position);
    }
}
