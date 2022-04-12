package step_2;

import java.util.Arrays;
import java.util.Collection;

public class Numbers {

    public static class Number {

        private final int value;

        public Number(String text) {
            this(Integer.parseInt(text));
        }

        private Number(int value) {
            toIntAndCheckNegativeNumber(value);
            this.value = value;
        }

        private void toIntAndCheckNegativeNumber(int value) {
            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
        }

        public int getValue() {
            return this.value;
        }

        public Number add(int beforeValue) {
            return new Number(Math.addExact(this.value, beforeValue));
        }
    }

    private final Number[] numbers;

    public Numbers(Collection<String> chars) {
        this.numbers = chars.stream()
                .map(Number::new)
                .toArray(Number[]::new);
    }

    public int sum() {
        return Arrays.stream(this.numbers)
                .reduce((before, after) -> after.add(before.getValue()))
                .orElseThrow((() -> new ArithmeticException("주어진 값을 더할 수 없습니다.")))
                .getValue();
    }

    public int size() {
        return this.numbers.length;
    }
}
