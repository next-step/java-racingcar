package calculator;


import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Calculator {

    private static String[] split(String input) {
        Double result = (double) 0L;

        if(input == null || "".equals(input)) {
            throw new IllegalArgumentException();
        }
        String[] split = input.split(" ");

        return split;
    }

    private static Double callCalculator(String[] split) {
        Double result = (double) parseInt(split[0]);

        int cnt = 0;

        int i = split.length - 2;
        while(cnt < i) {

            result = calculator(result
                    , (double) parseInt(split[cnt + 2])
                    , split[cnt + 1]);

            cnt = cnt + 2;
        }

        return result;
    }

    public static Double calculator(Double s1, Double s2, String op) {
        Double result = 0.0;

        switch (op) {
            case "+" :
                return plus(s1, s2);
            case "-" :
                return minus(s1, s2);
            case "*" :
                return multiply(s1, s2);
            case "/" :
                return devide(s1, s2);
            default:
                throw new IllegalArgumentException();
        }
    }

    private static Double plus(Double s1, Double s2) {
        return s1 + s2;
    }
    private static Double minus(Double s1, Double s2) {
        return s1 - s2;
    }
    private static Double multiply(Double s1, Double s2) {
        return s1 * s2;
    }
    private static Double devide(Double s1, Double s2) {
        return s1 / s2;
    }
    public static void main(String[] args){
        double result = 0;
        String input = "2 + 3 * 4 / 2";

        String[] split = split(input);

        result = callCalculator(split);

        System.out.println(result);
    }
}
