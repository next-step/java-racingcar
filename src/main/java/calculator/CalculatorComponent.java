package calculator;

import java.util.List;

public class CalculatorComponent {
    private final List<Positive> positiveList;
    private final Operator operator;

    public CalculatorComponent(List<Positive> positiveList, Operator operator) {
        this.positiveList = positiveList;
        this.operator = operator;
    }

    public int calculate() {
        if (positiveList.isEmpty()) {
            return 0;
        }
        int result = Number.calculateByOperator(new Number(), positiveList.get(0), Operator.PLUS);
        for (int i = 1; i < positiveList.size(); i++) {
            Positive positive = positiveList.get(i);
            Number resultNumber = new Number(result);
            result = Number.calculateByOperator(resultNumber, positive, this.operator);
        }
        return result;
    }
}
