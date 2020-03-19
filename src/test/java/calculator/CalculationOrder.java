package calculator;

import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Stack;

public class CalculationOrder {

    private Stack<String> order = new Stack<>();

    public void init(String[] inputs) {
        for(int i = inputs.length -1 ; i>=0; i--){
            order.push(inputs[i]);
        }
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

    public boolean isComplete() {
        return order.size() == 1;
    }

    public void addCalculateResult(long result) {
        order.push(String.valueOf(result));
    }

    public long getCalculateTotalResult() {
        return Long.parseLong(order.pop());
    }
}
