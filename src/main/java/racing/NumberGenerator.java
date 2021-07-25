package racing;

import java.util.Random;

public class NumberGenerator {
    static final int MIN_VALUE = 0;
    static final int MAX_VALUE = 9;

    private final Random random;
    private Number number;

    NumberGenerator() {
        random = new Random();
    }

    public void generateRandomNumber() {
        number = new Number(random.nextInt(MAX_VALUE + 1) + MIN_VALUE);
    }

    public int getRandomNumber() {
        validateNotEmpty(number);
        return number.getValue();
    }

    private void validateNotEmpty(Number number) {
       if (number == null) {
           throw new IllegalArgumentException("Number가 생성되지 않았습니다.");
       }
    }
}
