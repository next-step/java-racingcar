package calculator;

public class StringCalculator {
    public int calculate(String str) {
        String[] calElement = str.split(" ");
        int firstNum = Integer.parseInt(calElement[0]);
        String operation;
        int secondNum;

        for (int i = 1; i < calElement.length - 1; i += 2) {
            operation = calElement[i];
            secondNum = Integer.parseInt(calElement[i + 1]);

            Operator operator = Operator.searchOperator(operation);
            firstNum = operator.calculate(firstNum, secondNum);
        }

        return firstNum;
    }
}
