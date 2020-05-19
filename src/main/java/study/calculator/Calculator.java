package study.calculator;

public class Calculator {
    public String calculate(String input) {
        if(input == null || input.equalsIgnoreCase(""))
            throw new IllegalArgumentException();

        String[] splitInput = input.split(" ");

        if(splitInput.length < 3 || splitInput.length % 2 != 1)
            throw new IllegalArgumentException();

        String result = splitInput[0];

        for(int i=1; i<splitInput.length; i+=2)
            result = _calculate(result, splitInput[i], splitInput[i+1]);

        return result;
    }

    private String _calculate(String strNum1, String symbol, String strNum2) {
        int result;
        int num1 = Integer.parseInt(strNum1);
        int num2 = Integer.parseInt(strNum2);

        switch (symbol) {
            case "+":
                result = plus(num1, num2);
                break;
            case "-":
                result = minus(num1, num2);
                break;
            case "*":
                result = multiply(num1, num2);
                break;
            case "/":
                result = divide(num1, num2);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return String.valueOf(result);
    }

    private int plus(int num1, int num2) {
        return num1 + num2;
    }

    private int minus(int num1, int num2) {
        return num1 - num2;
    }

    private int multiply(int num1, int num2) {
        return num1 * num2;
    }
    
    private int divide(int num1, int num2) {
        return num1 / num2;
    }
}
