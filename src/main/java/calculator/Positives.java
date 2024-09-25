package calculator;

import java.util.ArrayList;
import java.util.List;

public class Positives {

    private List<Positive> positives;

    public Positives(String[] input) {
        this.positives = toPositives(input);
    }

    private List<Positive> toPositives(String[] input) {
        List<Positive> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            result.add(toPositive(input[i]));
        }
        return result;
    }

    private Positive toPositive(String value) {
        return Positive.of(value);
    }

    public int sum() {
        return positives.stream().mapToInt(Positive::number).sum();
    }

    static private class Positive {

        private static final String NOT_POSITIVE_MESSAGE = "숫자가 아닙니다.";
        ;
        private int number;

        private Positive(int value) {
            if (isNotPositive(value)) {
                throw new RuntimeException(NOT_POSITIVE_MESSAGE);
            }
            this.number = value;
        }

        private static boolean isNotPositive(int value) {
            return value < 0;
        }

        private static Positive of(String value) {
            if (isNotNumber(value)) {
                throw new RuntimeException(NOT_POSITIVE_MESSAGE);
            }
            return new Positive(Integer.parseInt(value));
        }

        private static boolean isNotNumber(String value) {
            return !value.matches("^\\d+$");
        }

        private int number() {
            return number;
        }
    }
}
