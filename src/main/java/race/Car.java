package race;

import java.util.Random;

public class Car {

    public static final String QUESTION = "자동차는 몇 대 입니까?";

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 10;
    private static final int THRESHOLD = 4;

    private int id;
    private int position;

    public Car(int id) {
        this.id = id;
        this.position = 0;
    }

    public static void validateCarCountRange(int carCount) {
        if (carCount < LOWER_BOUND || carCount > UPPER_BOUND) {
            throw new IllegalArgumentException("자동차 수는 "+ LOWER_BOUND +" ~ "+ UPPER_BOUND +"대 사이로 설정해야 합니다.");
        }
    }

    public void accelerate(int randomNumber) {
        if (randomNumber > THRESHOLD) {
            move();
        }
    }

    private void move() {
        position += 1;
    }

    public int getId() {
        return this.id;
    }

    public int getPosition() {
        return this.position;
    }
}
