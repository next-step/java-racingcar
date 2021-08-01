package carRacing;

import java.util.Random;

public class RandomMovigStrategy implements CarMovingStrategy{

    private static final int MOVE_STANDARD = 4;
    private static final int MAX_BOUNDS = 10;
    private static final int MIN = 0;
    private static final int MAX = MAX_BOUNDS -1;

    private final Random random = new Random();

    @Override
    public boolean isMove() {
        int number = getRandomNumber();

        if (number < MIN || number > MAX) {
            throw new IllegalStateException("랜덤 숫자의 유효범위를 벗어납니다.");
        }
        return number >= MOVE_STANDARD;
    }

    private int getRandomNumber() {
        return random.nextInt(MAX_BOUNDS);
    }
}
