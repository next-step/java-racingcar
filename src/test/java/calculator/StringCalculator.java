package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.operator.FourPointOperation;
import calculator.operator.FourPointOperation.Operation;

class StringCalculator {
    public static final String ERROR_MSG_BLANK = "잘못된 문자열 정보 입니다.";
    public static final String ERROR_MSG_NOT_SUPPORT_STR = "잘못된 특수기호가 포함된 문자열 정보 입니다.";
    public static final String STRING_CALCULATOR_FORMAT = "(\\d+)?( [-/*+] \\d+)+";
    private static final Pattern operatorPattern = Pattern.compile("(?<n0>\\d+)?( (?<op>[-/*+]) (?<n1>\\d+))");
    private final String data;

    public StringCalculator(String data) {
        if (null == data || data.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_MSG_BLANK);
        }
        if (false == data.matches(STRING_CALCULATOR_FORMAT)) {
            throw new IllegalArgumentException(ERROR_MSG_NOT_SUPPORT_STR);
        }
        this.data = data;
    }

    public int calculation() {
        Matcher matcher = operatorPattern.matcher(data);
        int result = 0;
        while(matcher.find()){
            int n0 = (null == matcher.group("n0")) ? result : Integer.parseInt(matcher.group("n0"));
            Operation operation = FourPointOperation.findOperation(matcher.group("op")).get();
            int n1 = Integer.parseInt(matcher.group("n1"));
            result = FourPointOperation.compute(n0, operation, n1);
        }
        return result;
    }
}
