package carRacing;

import java.util.Random;

public class Car {
    private static final int MOVE_STANDARD = 4;
    private static final int MAX_BOUNDS = 10;

    private int position;
    private final Random random;

    public Car(Random random) {
        this.random = random;
    }

    private boolean isMove(int number) {
        return number >= MOVE_STANDARD;
    }

    private int getRandomNumber() {
        return random.nextInt(MAX_BOUNDS);
    }

    int go() {
        int number = getRandomNumber();

        if (number < 0 || number > 9) {
            throw new IllegalStateException("랜덤 숫자의 유효범위를 벗어납니다.");
        }

        return isMove(number) ? ++position : position;
    }
}
