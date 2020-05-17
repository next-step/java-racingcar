package step2;

public class StringCalculator {
    public int calculate(String input) {
        CalculatorUtils.inputValidator(input);
        String[] strArray = input.split(CalculatorUtils.DELIMITER);

        int result = Integer.parseInt(strArray[0]);
        for(int i = 0; i < strArray.length-2; i += 2) {
            result = operate(strArray[i+1], result, Integer.parseInt(strArray[i+2]));
        }
        return result;
    }

    private int operate(String operator, int num1, int num2) {
        switch (operator) {
            case "+":
                return Operator.add(num1, num2);
            case "-":
                return Operator.sub(num1, num2);
            case "*":
                return Operator.mul(num1, num2);
            case "/":
                return Operator.div(num1, num2);
            default:
                return 0;
        }
    }
}