package racing.model;

import java.util.Random;

public class NumberGenerator {
    private final Random random;
    private Number number;

    public NumberGenerator() {
        random = new Random();
    }

    public void generateRandomNumber() {
        number = new Number(random.nextInt(10));
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
