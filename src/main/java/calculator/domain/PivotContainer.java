package calculator.domain;

import java.util.List;

public class PivotContainer {

    private static final String SPACE = "\\s+";
    private static final int IS_EVEN = 2;
    private final Operators operators;
    private final Numbers numbers;

    private PivotContainer(String userInput) {
        operators = Operators.get();
        numbers = Numbers.get();

        separateByNumbersAndOperators(split(userInput));
    }

    public static PivotContainer from(String userInput) {
        return new PivotContainer(userInput);
    }

    private String[] split(String userInput) {
        return userInput.trim().split(SPACE);
    }

    private void separateByNumbersAndOperators(String[] spaceSeperatedListOfUserInput) {
        int length = spaceSeperatedListOfUserInput.length;
        for (int pos = 0; pos < length; pos++) {
            addToList(isNumberLocated(pos), spaceSeperatedListOfUserInput[pos]);
        }
    }

    private void addToList(boolean isNumber, String numberOrOperator) {
        if (isNumber) {
            numbers.addNumber(numberOrOperator);
            return;
        }
        operators.addOperator(numberOrOperator);
    }

    private boolean isNumberLocated(int position) {
        return position % IS_EVEN == 0;
    }

    public List<Integer> getNumbers() {
        return this.numbers.getNumbers();
    }

    public List<Operator> getOperators() {
        return this.operators.getOperators();
    }
}
