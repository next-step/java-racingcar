import java.net.CacheRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private double accumulated;

    // 1. 공백만 들어왔는지
    private boolean blankCheck(String testStr) {
        return (testStr != null && !testStr.equals(""));
    }

    // 2. 숫자와 사칙연산 기호만 허용
    private boolean numArithmeticalOperationsCheck(String testStr) {
        String regx = "^[0-9\\+\\-\\*/\\s]+$";
        return testStr.trim().matches(regx);
    }

    // 3. 처음과 끝이 숫자가 맞는지
    private boolean isNumbers(String testStr) {
        return (testStr.charAt(0) - '0' < 10 && testStr.charAt(0) - '0' >= 0);
    }

    private boolean startEndIsNumCheck(String testStr) {
        String startStr = testStr.substring(0, 1);
        String endStr = testStr.substring(testStr.length() - 1);

        return isNumbers(startStr) && isNumbers(endStr);
    }

    // 조건 체크하는 함수
    public boolean conditionCheck(String testStr) {
        return blankCheck(testStr) && numArithmeticalOperationsCheck(testStr) && startEndIsNumCheck(testStr);
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
            // 연산자 체크하고 계산
            if(splitUp[i].equals("+")) {
                accumulated = plusOperation(accumulated, Double.parseDouble(splitUp[i + 1]));
            }

            if(splitUp[i].equals("-")) {
                accumulated = minusOperation(accumulated, Double.parseDouble(splitUp[i + 1]));
            }

            if(splitUp[i].equals("*")) {
                accumulated = multiplicationOperation(accumulated, Double.parseDouble(splitUp[i + 1]));
            }

            if(splitUp[i].equals("/")) {
                accumulated = divisionOperation(accumulated, Double.parseDouble(splitUp[i + 1]));
            }
        }
        return accumulated;
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

    private double divisionOperation(double accumulated, double operand) {
        return accumulated / operand;
    }
}
