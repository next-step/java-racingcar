package calculator;

import java.util.ArrayList;

public class Calculator {

    private static final String DEFAULT_DELIM = " ";

    public long eval(String s) {
        return eval(s, DEFAULT_DELIM);
    }

    public long eval(String s, String delim) {
        if (s == null) {
            throw new IllegalArgumentException("null");
        }

        String[] tokens = s.split(delim);

        TokenSequence sequence = new TokenSequence();
        ArithmeticOperator operator = null;
        ArrayList<Long> operands = new ArrayList<>();

        for(String token : tokens) {
            if (sequence.shouldOperator()) {
                operator = ArithmeticOperator.of(token);
            } else if (sequence.shouldOperand()) {
                operands.add(new Long(token));
            } else {
                throw new IllegalArgumentException("invalid token sequence " + token);
            }

            if (operands.size() == ArithmeticOperator.REQUIRED_NUM_OPERANDS) {
                long v = operator.eval(operands);

                operands.clear();
                operands.add(v);
                operator = null;
            }

            sequence.next();
        }

        if (operands.size() == 1) {
            return operands.get(0);
        }

        throw new ArithmeticException("something went wrong");
    }

}
