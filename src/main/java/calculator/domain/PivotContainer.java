package calculator.domain;

import java.util.List;

public class PivotContainer {

    private Operator operator;
    private Number number;

    private PivotContainer(String userInput) {
        operator = Operator.get();
        number = Number.get();

        try {
            seperateLineAndPushToList(split(userInput));
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

    public void seperateLineAndPushToList(String[] lineArr) {
        try {
            for (int i = 0; i < lineArr.length; i++) {
                if (i % 2 == 0) {
                    number.addNumber(lineArr[i]);
                    continue;
                }
                operator.addOperator(lineArr[i]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            number.clear();
            operator.clear();
        }
    }

    public List<Integer> getNumbers() {
        return this.number.getNumbers();
    }

    public List<String> getOperators() {
        return this.operator.getOperators();
    }
}
