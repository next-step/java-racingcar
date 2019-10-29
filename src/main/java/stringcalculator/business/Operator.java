package stringcalculator.business;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class Operator implements Unit {

    static final String PLUS = "+";
    static final String MINUS = "-";
    static final String MULTIPLY = "*";
    static final String DIVIDE = "/";
    static final Set<String> ENABLE_OPERATOR = ImmutableSet.of(PLUS, MINUS, MULTIPLY, DIVIDE);

    private String value;

    private Operator(final String value) {
        hasOperator(value);
        this.value = value;
    }

    static Operator of(final String value) {
        return new Operator(value);
    }

    private void hasOperator(final String value) {
        if (!ENABLE_OPERATOR.contains(value)) {
            throw new IllegalArgumentException();
        }
    }

    String getValue() {
        return value;
    }

    @Override
    public int getType() {
        return OPERATOR;
    }
}
