package com.nextstep.calculator;

import java.io.InputStream;
import java.util.Scanner;

public class StringCalculator {
    private final Scanner scanner;
    private final Validator validator = new Validator();

    public static void main(String[] args) {
        new StringCalculator().run();
    }

    public StringCalculator() {
        this(System.in);
    }

    public StringCalculator(InputStream is) {
        this.scanner = new Scanner(is);
    }

    public void run() {
        String input = scanner.nextLine();
        try {
            validator.validate(input);
            Accumulator accumulator = calculate(input);
            System.out.println(accumulator.getValue());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private Accumulator calculate(String input) {
        final int beginIdx = 0;
        String[] temp = input.split(" ");
        int begin = Integer.parseInt(temp[beginIdx]);
        Accumulator accumulator = new Accumulator(begin);
        for (int i = 1 ; i < temp.length ; i = i + 2) {
            String symbol = temp[i];
            int number = Integer.parseInt(temp[i+1]);
            accumulator.calculate(symbol, number);
        }
        return accumulator;
    }
}
