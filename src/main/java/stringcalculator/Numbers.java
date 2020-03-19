package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Number> numbers = new ArrayList<>();

    public Numbers(Expression expression) {
        for (String item : expression.getExpression()) {
            parseNumber(item);
        }
    }

    public int size() {
        return numbers.size();
    }

    private void parseNumber(String expression) {
        try {
            numbers.add(new Number(Long.parseLong(expression)));
        } catch (NumberFormatException e) {
        }
    }

    public Number getFirstOneAndRemove() {
        Number number = numbers.get(0);
        numbers.remove(0);
        return number;
    }
}
