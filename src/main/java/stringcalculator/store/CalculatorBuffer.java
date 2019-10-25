package stringcalculator.store;

public class CalculatorBuffer {
    private static final String NUMBER_FORMAT = "\\d";

    private NumberCollection numberCollection;
    private OperatorCollection operatorCollection;

    public CalculatorBuffer(String[] parsedInputs) {
        validateOperateOrder(parsedInputs);
        this.numberCollection = new NumberCollection(parsedInputs);
        this.operatorCollection = new OperatorCollection(parsedInputs);
        validateOperationSize(numberCollection, operatorCollection);
    }

    private void validateOperateOrder(String[] parsedInputs) {
        for (int i = 0; i < parsedInputs.length; i++) {
            checkOrder(parsedInputs, i);
        }
    }

    private void checkOrder(String[] parsedInputs, int i) {
        if (i % 2 == 0) {
            checkNumber(parsedInputs[i]);
            return;
        }
        checkNotNumber(parsedInputs[i]);
    }

    private void checkNumber(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException("연산자의 순서가 올바르지 않습니다.");
        }
    }

    private void checkNotNumber(String input) {
        if (isNumber(input)) {
            throw new IllegalArgumentException("숫자의 순서가 올바르지 않습니다.");
        }
    }

    private boolean isNumber(String input) {
        return input.matches(NUMBER_FORMAT);
    }

    private void validateOperationSize(NumberCollection numberCollection, OperatorCollection operatorCollection) {
        int numberSize = numberCollection.getNumbers()
                .size();
        int operatorSize = operatorCollection.getOperators()
                .size();
        if (canOperate(numberSize, operatorSize)) {
            throw new IllegalArgumentException("연산할 수 없는 식 입니다.");
        }
    }

    private boolean canOperate(int numberSize, int operateSize) {
        return numberSize != operateSize + 1;
    }

}
