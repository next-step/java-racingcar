package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public int sum(String input) {
        if (isEmpty(input)) return 0;
        return sum(toPositives(split(input)));
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }

    private int sum(List<Positive> input) {
        return input.stream().reduce(Positive::sum).map(Positive::number).orElse(0);
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

    private String[] split(String input) {
        return input.split("[:,]");
    }

    static private class Positive{
        private int number;

        private Positive(int value){
            if(isNotPositive(value)){
                throw new RuntimeException("숫자가 아닙니다.");
            }
            this.number=value;
        }

        private static boolean isNotPositive(int value) {
            return value<0;
        }
        public static Positive of(String value){
            if (isNotNumber(value)) throw new RuntimeException("숫자가 아닙니다.");
            return new Positive(Integer.parseInt(value));
        }

        private static boolean isNotNumber(String value) {
            return !value.matches("^\\d+$");
        }

        public Positive sum(Positive positive){
            return new Positive(positive.number+this.number);
        }

        public int number(){
            return number;
        }
    }
}
