package stringcalculator.business;

class CentralProcessingUnit {

    int operate(final int operand1, final int operand2, final String operator) {

        if (Operator.PLUS.equals(operator)) {
            return plus(operand1, operand2);
        }

        if (Operator.MINUS.equals(operator)) {
            return minus(operand1, operand2);
        }

        if (Operator.MULTIPLY.equals(operator)) {
            return multiply(operand1, operand2);
        }

        return divide(operand1, operand2);
    }

    private int plus(int operand1, int operand2) {
        return operand1 + operand2;
    }

    private int minus(int operand1, int operand2) {
        return operand1 - operand2;
    }

    private int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    private int divide(int operand1, int operand2) {
        return operand1 / operand2;
    }
}
