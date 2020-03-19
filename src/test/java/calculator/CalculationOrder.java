package calculator;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

public class CalculationOrder {

    private Stack<String> order = new Stack<>();

    public void init(String[] inputs) {
        for (String input : inputs) {
            order.push(input);
        }
        order.sort(Collections.reverseOrder());
    }

    public String next() {
        String next = "";
        try {
            next = order.pop();
        } catch (EmptyStackException e) {
            return null;
        }
        return next;
    }

    public void addCalculateResult(long result) {
        order.push(String.valueOf(result));
    }
}
