package step4.domain;

import java.util.Random;

public class RandomNumber {
    public static final int LIMIT = 10;
    public static final int ZERO = 0;

    private int randomNumber;

    public RandomNumber(int generatedNumber) {
        if (generatedNumber < ZERO || generatedNumber >= LIMIT) {
            throw new IllegalArgumentException("랜덤 숫자가 잘못 생성되었습니다.");
        }
        this.randomNumber = generatedNumber;
    }

    public static RandomNumber generate() {
        Random random = new Random();
        return new RandomNumber(random.nextInt(LIMIT));
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
