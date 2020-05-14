public class Operation {
    private double accumulatedCalcResult;

    public double operator(String operation, double firstNum, double secondNum) {
        switch (operation) {
            case "+":
                accumulatedCalcResult = plusOperation(firstNum, secondNum);
                break;
            case "-":
                accumulatedCalcResult = minusOperation(firstNum, secondNum);
                break;
            case "*":
                accumulatedCalcResult = multiplicationOperation(firstNum, secondNum);
                break;
            case "/":
                try {
                    accumulatedCalcResult = divisionOperation(firstNum, secondNum);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new IllegalArgumentException("you are allow to use only arithmetic operation");
        }

        return accumulatedCalcResult;
    }

    private double plusOperation(double accumulated, double operand) {
        return accumulated + operand;
    }

    private double minusOperation(double accumulated, double operand) {
        return accumulated - operand;
    }

    private double multiplicationOperation(double accumulated, double operand) {
        return accumulated * operand;
    }

    public double divisionOperation(double accumulated, double operand) throws IllegalArgumentException {
        if (operand == 0) {
            throw new IllegalArgumentException("you can't divide by 0");
        }
        return accumulated / operand;
    }

}
