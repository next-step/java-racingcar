package com.jaeyeonling.calculator;

public class CalculateValue {

    private static final String SEPARATOR = " ";

    private final String[] splitValue;

    private CalculateValue (final String[] splitValue) {
        this.splitValue = splitValue;
    }

    public static CalculateValue text(final String text) {
        if (isInvalidText(text)) {
            throw new IllegalArgumentException();
        }

        return new CalculateValue(text.split(SEPARATOR));
    }


    //
    //
    //

    private static boolean isInvalidText(final String text) {
        return text == null || text.isEmpty();
    }
}
