package com.nextstep.calculator;

import java.util.Scanner;

public class StringCalculator {
    private final Validator validator = new Validator();
    private final String input;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringCalculator stringCalculator = new StringCalculator(input);
        try {
            int result = stringCalculator.calculate();
            System.out.println(result);
        } catch ( IllegalArgumentException e ) {
            System.out.println(e.getMessage());
        }
    }

    public StringCalculator(String input) {
        this.input = input;
    }

    public int calculate() {
        validator.validate(input);
        return calculate(input);
    }

    private int calculate(String input) {
        final int beginIdx = 0;
        String[] temp = input.split(" ");
        int begin = Integer.parseInt(temp[beginIdx]);
        Accumulator accumulator = new Accumulator(begin);
        for (int i = 1 ; i < temp.length ; i = i + 2) {
            String symbol = temp[i];
            int number = Integer.parseInt(temp[i+1]);
            accumulator.calculate(symbol, number);
        }
        return accumulator.getValue();
    }
}
