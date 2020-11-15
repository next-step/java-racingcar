package calculator;

import java.util.*;

import static java.lang.Integer.parseInt;
import static calculator.Operator.parseOperator;

public class StringCalculator {
    private static final String EXPRESSION_DELIMITERS = " ";
    protected final StringTokenizer tokenizer;

    protected StringCalculator(String expression) {
        if(expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("expression omitted");
        }
        tokenizer = new StringTokenizer(expression, EXPRESSION_DELIMITERS);
    }

    // convenience method
    public static int calculate(String expression) {
        return new StringCalculator(expression).calculate();
    }

    private int calculate() {
        // leftmost derivation { lhs = ( (lhs op1 rhs1) op2 rhs2 ) ... }
        int lhs = parseInt(nextToken());
        while(tokenizer.hasMoreElements()) {
            lhs = calculateOne(lhs);
        }
        return lhs;
    }

    protected int calculateOne(int base) {
        return parseOperator(nextToken())
                .operate(base, parseInt(nextToken()));
    }

    protected String nextToken() {
        try {
            return tokenizer.nextToken();
        } catch(NoSuchElementException ex) {
            // token이 필요한데 없을 땐, IllegalArgumentException
            throw new IllegalArgumentException("incomplete expression");
        }
    }
}
