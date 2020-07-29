package study;

public class CalcImpl implements Calc {

    @Override
    public int cal(String input) {
        preconditions(input);
        String[] splited = input.split(" ");
        int initValue = Integer.valueOf(splited[0]);
        for (int i = 1; i < splited.length; i = i + 2) {
            initValue = doCal(initValue, Integer.valueOf(splited[i + 1]), splited[i]);
        }
        return initValue;
    }

    private void preconditions(String input) {
        if(input == null || input.trim().equals("")) throw new IllegalArgumentException();
    }

    private int doCal(int operand1, int operand2, String operation) {
        switch(operation) {
            case "+": return plus(operand1, operand2);
            case "-": return subtract(operand1, operand2);
            case "*": return multiply(operand1, operand2);
            case "/": return division(operand1, operand2);
            default: throw new IllegalArgumentException();
        }
    }

    private int plus(int operand1, int operand2) {
        return operand1 + operand2;
    }

    private int subtract(int operand1, int operand2) {
        return operand1 - operand2;
    }

    private int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    private int division(int operand1, int operand2) {
        return operand1 / operand2;
    }

}
