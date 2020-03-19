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

    public List<Number> getNumbers() {
        return numbers;
    }

    private void parseNumber(String expression) {
        try {
            numbers.add(new Number(Integer.parseInt(expression)));
        } catch (NumberFormatException e) {
        }
    }
}
