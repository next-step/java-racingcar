public class Calculator {
    private double accumulated;

    // 1. 공백만 들어왔는지
    public boolean blankCheck(String testStr) {
        if (testStr == null || testStr.trim().equals("")) {
            throw new IllegalArgumentException("this is empty string");
        }
        return true;
    }

    // 2. 숫자와 사칙연산 기호만 허용
    private boolean numOperationsCheck(String testStr) {
        String regx = "^[0-9\\+\\-\\*/\\s]+$";
        if (!testStr.trim().matches(regx)) {
            throw new IllegalArgumentException("you are allow to use only number or arithmetic operation");
        }
        return true;
    }

    // 3. 처음과 끝이 숫자가 맞는지
    private boolean isNumbers(String testStr) {
        return (testStr.charAt(0) - '0' < 10 && testStr.charAt(0) - '0' >= 0);
    }

    private boolean startEndIsNumCheck(String testStr) {
        String startStr = testStr.substring(0, 1);
        String endStr = testStr.substring(testStr.length() - 1);

        if (!isNumbers(startStr) || !isNumbers(endStr)) {
            throw new IllegalArgumentException("start and end char must be number to calculate");
        }
        return true;
    }

    // 조건 체크하는 함수
    public boolean conditionCheck(String testStr) {
        return blankCheck(testStr) && numOperationsCheck(testStr) && startEndIsNumCheck(testStr);
    }

    // 연산
    public double calculate(String testStr) {
        // 조건 체크
        conditionCheck(testStr);

        // 쪼개고
        String[] splitUp = testStr.split(" ");
        accumulated = Double.parseDouble(splitUp[0]);

        // 계산
        for(int i = 1; i < splitUp.length; i += 2) {
            operation(splitUp[i], accumulated, Double.parseDouble(splitUp[i + 1]));
        }

        return accumulated;
    }

    private void operation(String operation, double firstNum, double secondNum) {
        switch (operation) {
            case "+":
                accumulated = plusOperation(firstNum, secondNum);
                break;
            case "-":
                accumulated = minusOperation(firstNum, secondNum);
                break;
            case "*":
                accumulated = multiplicationOperation(firstNum, secondNum);
                break;
            case "/":
                try {
                    accumulated = divisionOperation(firstNum, secondNum);
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
        if(operand == 0) {
            throw new IllegalArgumentException("you can't divide by 0");
        }
        return accumulated / operand;
    }
}
