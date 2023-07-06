package calculator.service;

import calculator.parser.NumberParser;

public final class Calculator {

    private static class CalculatorHolder {
        private static final Calculator INSTANCE = new Calculator();
    }

    private final NumberParser numberParser;

    private Calculator() {
        this.numberParser = NumberParser.getInstance();
    }

    public static Calculator getInstance() {
        return CalculatorHolder.INSTANCE;
    }

    public int sum(final String text) {
        return numberParser.parse(text)
                           .sum();
    }
}
