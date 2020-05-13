public class Calculator {
    public String calculate(String input) {
        if(input == null || input.equalsIgnoreCase(""))
            throw new IllegalArgumentException();

        String[] splitInput = input.split(" ");

        if(splitInput.length < 3 || splitInput.length % 2 != 1)
            throw new IllegalArgumentException();

        String result;
        result = _calculate(splitInput[0], splitInput[1], splitInput[2]);

        for(int i=3; i<splitInput.length; i+=2)
            result = _calculate(result, splitInput[i], splitInput[i+1]);

        return result;
    }

    private int convertToInteger(String str) {
        return Integer.parseInt(str);
    }

    private String _calculate(String strNum1, String symbol, String strNum2) {
        int result;
        int num1 = convertToInteger(strNum1);
        int num2 = convertToInteger(strNum2);

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
