package racing.model;

import java.util.Random;

public class NumberGenerator {
    static final int MIN_NUMBER = 0;
    static final int MAX_NUMBER = 9;

    private final Random random;
    private Number number;

    public NumberGenerator() {
        random = new Random();
    }

    public void generateRandomNumber() {
        number = new Number(random.nextInt(MAX_NUMBER + 1) + MIN_NUMBER);
    }

    public Number getNumber() {
        validateNotNull(number);
        return number;
    }

    private void validateNotNull(Number number) {
       if (number == null) {
           throw new IllegalStateException("Number가 생성되지 않았습니다.");
       }
    }
}
