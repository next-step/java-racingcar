package calculator;

public class Calculator {

    private final Validation validation;
    private int result;

    public Calculator() {
        validation = new Validation();
        result = 0;
    }

    public String[] getInputArray(String inputStr) {
        String[] inputArr = validation.checkInputValidation(inputStr).split(" ");
        validation.checkValidation(inputArr);

        return inputArr;
    }

    public int calculate(String inputStr) {

        String[] inputArr = getInputArray(inputStr);

        for (int i = 0; i < inputArr.length - 2; i += 2) {
            validation.checkValidation(inputArr[i + 1], inputArr[i], inputArr[i + 2]);

            result = i == 0 ? Integer.parseInt(inputArr[i]) : result;
            setResult(inputArr[i + 1], result, Integer.parseInt(inputArr[i + 2]));
        }

        return result;
    }

    private void setResult(String operator, int num1, int num2) {
        if ("+".equals(operator)) {
            result = plus(num1, num2);
        }
        if ("-".equals(operator)) {
            result = minus(num1, num2);
        }
        if ("*".equals(operator)) {
            result = multiplication(num1, num2);
        }
        if ("/".equals(operator)) {
            result = devision(num1, num2);
        }
    }

    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    public int devision(int num1, int num2) {
        return num1 / num2;
    }
}
