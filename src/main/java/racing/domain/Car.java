package racing.domain;

import java.util.Random;

public class Car {
    private static final int MIN_NUMBER = 4;
    private static final int RANDOM_MAX_NUMBER = 10;

    private int position;
    private final String name;

    private Random random = new Random();

    public Car(String name) {
        this.position = 0;
        this.name = name;
    }

    public void run(int random) {
        if (checkMove(random)) {
            move();
        }
    }

    public int getRandomNumber() {
        return random.nextInt(RANDOM_MAX_NUMBER);
    }

    private void move() {
        this.position++;
    }

    private boolean checkMove(int randomNumber) {
        return randomNumber >= MIN_NUMBER;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
