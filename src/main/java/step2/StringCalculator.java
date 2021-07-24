package step2;

public class StringCalculator {

    public int calculate(String input) {

        validateInput(input);
        String[] result = input.split(" ");

        int rst = toInt(result[0]);

        for (int i = 1; i < result.length; i+=2) {
            rst = calculate(rst, toInt(result[i+1]), result[i]);
        }

        return rst;
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
