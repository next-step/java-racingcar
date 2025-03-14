package racingcar.calculator;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String str) throws RuntimeException {
        StringAddCalculatorParser parser = new StringAddCalculatorParser(StringAddCalculatorLexer.analyze(str));

        return sum(parser.parse());
//        return Arrays.stream(parser.parse()).sum();
    }

    private static int sum(int[] ints) {
        int sum = 0;
        for (int anInt : ints) {
            sum += anInt;
        }

        return sum;
    }
}
