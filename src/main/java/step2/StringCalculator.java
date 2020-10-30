package step2;

import java.util.*;

import static java.lang.Integer.parseInt;
import static step2.Operator.parseOperator;

public class StringCalculator {
    final StringTokenizer tokenizer;

    // convenience method
    public static int calculate(String expression) {
        return new StringCalculator(expression).calculate();
    }

    public StringCalculator(String expression) {
        if(expression == null || expression.isBlank()) {
            throw new IllegalArgumentException();
        }
        tokenizer = new StringTokenizer(expression, " ");
    }

    public int calculate() {
        // leftmost derivation { lhs = ( (lhs op1 rhs1) op2 rhs2 ) ... }
        int lhs = parseInt(nextToken());
        while(tokenizer.hasMoreElements()) {
            lhs = calculateOne(lhs);
        }
        return lhs;
    }

    int calculateOne(int base) {
        return parseOperator(nextToken())
                .operate(base, parseInt(nextToken()));
    }

    String nextToken() {
        try {
            return tokenizer.nextToken();
        } catch(NoSuchElementException ex) {
            // token이 필요한데 없을 땐, IllegalArgumentException
            throw new IllegalArgumentException();
        }
    }
}
