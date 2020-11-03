package study;

public class StringCalculator {
    private String[] inputs;
    private int firstOperand;
    private int secondOperand;
    private OperationType operator;
    private int result;

    public int calculate(String input) throws IllegalArgumentException{
        parseInputs(input);

        setFirstOperand(inputs[0]);
        for (int i = 1; i < inputs.length; i = i + 2) {
            if (!isEven(i)) {
                setOperator(inputs[i]);
            }

            if (isEven(i + 1)) {
                setSecondOperand(inputs[i + 1]);

            }

            operateFourCalculation(operator);
        }

        return result;
    }

    private void setFirstOperand(String input) {
        firstOperand = Integer.parseInt(input);
    }

    private void setSecondOperand(String input) {
        secondOperand = Integer.parseInt(input);
    }

    private void setOperator(String operator) throws IllegalArgumentException{
        if (!isValidOperator(operator)) {
            throw new IllegalArgumentException();
        } else {
            this.operator = OperationType.findByOperator(operator);
        }
    }

    private void operateFourCalculation(OperationType operator){
        switch(operator){
            case ADD:
                result = add(firstOperand, secondOperand);
                break;
            case SUBTRACT:
                result = subtract(firstOperand, secondOperand);
                break;
            case MULTIPLE:
                result = multiple(firstOperand, secondOperand);
                break;
            case DIVIDE:
                result = divide(firstOperand, secondOperand);
                break;
            default:
                break;
        }
        firstOperand = result;
    }

    private int divide(int firstOperand, int secondOperand) {
        return firstOperand / secondOperand;
    }

    private int multiple(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }

    private int subtract(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    private int add(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    private void parseInputs(String input) throws IllegalArgumentException{
        if (this.isNullOrEmptyString(input)) {
            throw new IllegalArgumentException();
        }
        inputs = input.split(" ");
    }

    private boolean isValidOperator(String input) {
        return input.equals("+") || input.equals("-")
                || input.equals("*") || input.equals("/");
    }

    private boolean isNullOrEmptyString(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean isEven(int number) {
        return (number % 2) == 0;
    }
}

