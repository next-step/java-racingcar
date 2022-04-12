package step_2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
    }

    private final Number[] numbers;
    private final int size;

    public Numbers(Collection<String> chars) {
        this.numbers = chars.stream().map(Number::new).toArray(Number[]::new);
        this.size = numbers.length;
    }

    public List<Integer> getValues() {
        return Arrays.stream(this.numbers).map(Number::getValue).collect(Collectors.toList());
    }

    public int size() {
        return size;
    }
}
