package caculator.model;

import java.util.regex.Pattern;

public class Element {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("(^-?[0-9]+$)");

    private final String operand;

    public Element(final String operand) {
        validate(operand);

        this.operand = operand;
    }

    private void validate(final String operand) {
        if (operand.isEmpty()
                || !isNumber(operand)
                || isNegative(operand)) {
            throw new RuntimeException();
        }
    }

    private boolean isNumber(final String operand) {
        return NUMBER_PATTERN.matcher(operand).find();
    }

    private boolean isNegative(final String operand) {
        return Integer.parseInt(operand) < 0;
    }

    public int toInt() {
        return Integer.parseInt(this.operand);
    }

}
