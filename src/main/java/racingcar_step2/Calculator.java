package racingcar_step2;

public class Calculator {

    private String[] splitValue;
    private int result = 0;

    public Calculator(String input) {
        validateInput(input);
        this.splitValue = splitInputString(input);
        runCalculator(this.splitValue);
    }

    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input Value Error");
        }
    }

    private String[] splitInputString(String input) {
        String[] values = input.split(" ");
        return values;
    }

    private void runCalculator(String[] splitValue) {
        String operatorChar = "";
        this.result = Integer.parseInt(splitValue[0]);

        for (int i=0; i < splitValue.length; i++) {
            if(!isNumber(splitValue[i])){
                operatorChar = splitValue[i];
                Operator(this.result, Integer.parseInt(splitValue[i+1]), operatorChar);
            }
        }
    }

    private boolean isNumber(String value) {
        if(value.matches("^[0-9]*$")){
            return true;
        }
        return  false;
    }

    private void Operator(int firstNumber, int secondNumber, String operatorChar) {
        switch (operatorChar) {
            case "+":
                this.result = add(firstNumber, secondNumber);
                break;
            case "-":
                this.result = minus(firstNumber, secondNumber);
                break;
            case "*":
                this.result = multiplication(firstNumber, secondNumber);
                break;
            case "/":
                this.result = division(firstNumber, secondNumber);
                break;
            default:
                throw new IllegalArgumentException("This is Disabled character.");
        }
    }

    private int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private int minus(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    private int multiplication(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    private int division(int firstNumber, int secondNumber) throws IllegalArgumentException {
        if(secondNumber == 0){
            throw new IllegalArgumentException("secondNumber by zero");
        }
        return firstNumber / secondNumber;
    }

    public int getResult() {
        return this.result;
    }
}
