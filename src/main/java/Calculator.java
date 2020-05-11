import java.net.CacheRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    double accumulated;

    // 연산
    public double calculate(String testStr) {
        // 조건 체크
            // 1. 공백 안 됨
            // 2. 숫자, 사칙연산 문자만 허용
            // 3. 앞, 뒤는 숫자

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
