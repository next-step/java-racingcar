package RacingGame;

import java.util.Random;

public class Car {

    private final int TRANSFER_UNIT = 1;
    private final int BASE_BOUND = 10;
    private final int REFERENCE_VALUE = 4;

    private String name;
    private int position;

    public Car() {
        this.position = 0;
    }

    public Car(String name) {
        this();
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean isMove) {
        if (isMove) {
            this.position += TRANSFER_UNIT;
        }
    }

    public int getRandomNumber() {
        Random random = new Random();

        return random.nextInt(BASE_BOUND);
    }

    public boolean isMoveCar(int randomNumber) {
        return randomNumber > REFERENCE_VALUE;
    }

    public void nextRace() {
        int randomNumber = this.getRandomNumber();
        boolean isMoveCar = this.isMoveCar(randomNumber);
        this.move(isMoveCar);
    }

    public String getName() {
        return this.name;
    }


}
