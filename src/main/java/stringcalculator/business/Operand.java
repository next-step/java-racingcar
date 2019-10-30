package stringcalculator.business;

import java.util.regex.Pattern;

public class Operand implements Unit {

    private static final Pattern ONLY_NUMBER = Pattern.compile("^[0-9]*$");

    private int value;

    private Operand(final String value) {
        hasNumber(value);
        this.value = Integer.parseInt(value);
    }

    static Operand of(final String value) {
        return new Operand(value);
    }

    private void hasNumber(final String number) {
        if (!ONLY_NUMBER.matcher(number).matches()) {
            throw new IllegalArgumentException();
        }
    }

    int getValue() {
        return value;
    }

    @Override
    public int getType() {
        return OPERAND;
    }
}
