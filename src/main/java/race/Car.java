package race;

import java.util.Random;

public class Car {

    public static final String QUESTION = "자동차는 몇 대 입니까?";

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 10;
    private static final int THRESHOLD = 4;
    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자까지 가능합니다. : " + name);
        }
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

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
