public class Calculator {
    private double accumulatedCalcResult;

    // 1. 공백만 들어왔는지
    public boolean isBlank(String strForCalc) {
        if (strForCalc == null || strForCalc.trim().equals("")) {
            throw new IllegalArgumentException("this is empty string");
        }
        return true;
    }

    // 2. 숫자와 사칙연산 기호만 허용
    private boolean allowOnlyNumOperations(String strForCalc) {
        String regx = "^[0-9\\+\\-\\*/\\s]+$";
        if (!strForCalc.trim().matches(regx)) {
            throw new IllegalArgumentException("you are allow to use only number or arithmetic operation");
        }
        return true;
    }

    // 3. 처음과 끝이 숫자가 맞는지
    private boolean isNumber(String strForCalc) {
        return (strForCalc.charAt(0) - '0' < 10 && strForCalc.charAt(0) - '0' >= 0);
    }

    private boolean isFirstEndNum(String strForCalc) {
        String startStr = strForCalc.substring(0, 1);
        String endStr = strForCalc.substring(strForCalc.length() - 1);

        if (!isNumber(startStr) || !isNumber(endStr)) {
            throw new IllegalArgumentException("start and end char must be number to calculate");
        }
        return true;
    }

    // 조건 체크하는 함수
    public boolean conditionCheck(String strForCalc) {
        return isBlank(strForCalc) && allowOnlyNumOperations(strForCalc) && isFirstEndNum(strForCalc);
    }

    // 연산
    public double calculate(String strForCalc) {
        // 조건 체크
        conditionCheck(strForCalc);

        // 쪼개고
        String[] splitUp = strForCalc.split(" ");
        accumulatedCalcResult = Double.parseDouble(splitUp[0]);

        // 계산
        for (int i = 1; i < splitUp.length; i += 2) {
            operation(splitUp[i], accumulatedCalcResult, Double.parseDouble(splitUp[i + 1]));
        }

        return accumulatedCalcResult;
    }

    private void operation(String operation, double firstNum, double secondNum) {
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
        }
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
