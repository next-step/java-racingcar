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
            if (!Utils.isEven(i)) {
                setOperator(inputs[i]);
            }

            if (Utils.isEven(i + 1)) {
                setSecondOperand(inputs[i + 1]);
            }

            result = operator.operate(firstOperand, secondOperand);
            firstOperand = result;
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
        this.operator = OperationType.findByOperator(operator);
    }

    private void parseInputs(String input) throws IllegalArgumentException{
        if (Utils.isNullOrEmptyString(input)) {
            throw new IllegalArgumentException();
        }
        inputs = input.split(" ");
    }
}

