package step2;

public class StringCalculator {

    public int calculate(String input) {

        validateInput(input);
        String[] inputArray = input.split(" ");

        int result = toInt(inputArray[0]);

        for (int i = 1; i < inputArray.length; i+=2) {
            result = calculate(result, toInt(inputArray[i+1]), inputArray[i]);
        }

        return result;
    }

    private void validateInput(String input) {
        if(input.trim().equals("") || input == null) {
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }
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
