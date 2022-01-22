package calculator.domain;

import java.util.List;

public class PivotContainer {

    private Operator operator;
    private Number number;

    private PivotContainer(String userInput) {
        operator = Operator.get();
        number = Number.get();

        try {
            separateByNumbersAndOperators(split(userInput));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static PivotContainer get(String userInput) {
        return new PivotContainer(userInput);
    }

    public String[] split(String userInput) {
        return userInput.trim().split("\\s+");
    }

    public void separateByNumbersAndOperators(String[] spaceSeperatedListOfUserInput) {
        try {
            int length = spaceSeperatedListOfUserInput.length;
            for (int pos = 0; pos < length; pos++) {
                addToList(isNumberLocated(pos), spaceSeperatedListOfUserInput[pos]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            number.clear();
            operator.clear();
        }
    }

    private void addToList(boolean isNumber, String numberOrOperator) {
        if (isNumber) {
            number.addNumber(numberOrOperator);
            return;
        }
        operator.addOperator(numberOrOperator);
    }

    private boolean isNumberLocated(int position) {
        return position % 2 == 0;
    }

    public List<Integer> getNumbers() {
        return this.number.getNumbers();
    }

    public List<String> getOperators() {
        return this.operator.getOperators();
    }
}
