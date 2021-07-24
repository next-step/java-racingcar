package step2;

public class StringCalculator {

    public int calculate(String input) {
        String[] result = input.split(" ");
        int firstOperand = toInt(result[0]);
        int secondOperand = toInt(result[2]);
        String operator = result[1];
        return calculate(firstOperand, secondOperand, operator);
    }

    private int calculate(int firstOperand, int secondOperand, String operator) {
        return findOperator(operator).calculate(firstOperand, secondOperand);
    }

    private Operator findOperator(String operator) {
        return Operator.find(operator);
    }

    private int toInt(String s) {
        return Integer.parseInt(s);
    }


}
