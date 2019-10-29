package step1;

public class StringCalculator {
    private String inputRequest;
    private String[] inputs;
    private final static String SEPARATOR = " ";

    public StringCalculator() {

    }

    public StringCalculator(String inputRequest) {
        this.inputRequest = inputRequest;
        inputValidate();
        this.inputs = inputRequest.split(SEPARATOR);
    }

    public void inputValidate() {
        if (inputRequest == null || inputRequest.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public int execute() {
        return calculate(inputs.length - 1);
    }

    public int calculate(int number) {
        if (number == 0) {
            return Integer.parseInt(inputs[number]);
        }
        return branchMethod(number);
    }

    private int branchMethod(int number) {
        switch (inputs[number]) {
            case "+":
                return add(number);
            case "-":
                return subtract(number);
            case "*":
                return multiply(number);
            case "/":
                return divide(number);
            default:
                return numberCheck(number);
        }
    }

    private int add(int number) {
        return calculate(number - 1) + Integer.parseInt(inputs[number + 1]);
    }

    private int subtract(int number) {
        return calculate(number - 1) - Integer.parseInt(inputs[number + 1]);
    }

    private int divide(int number) {
        return calculate(number - 1) / Integer.parseInt(inputs[number + 1]);
    }

    private int multiply(int number) {
        return calculate(number - 1) * Integer.parseInt(inputs[number + 1]);
    }

    private int numberCheck(int number) {
        try {
            Integer.parseInt(inputs[number]);
            return calculate(number - 1);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
