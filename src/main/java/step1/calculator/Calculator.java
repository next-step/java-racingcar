package step1.calculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    private static final String SPLIT_BLANK_REGEX = " ";
    private static List<String> operatorList = Stream.of(Operator.values())
            .map(m -> m.getName())
            .collect(Collectors.toList());

    public static long plus(long first, long second) {
        return first + second;
    }

    public static long minus(long first, long second) {
        return first - second;
    }

    public static long multiply(long first, long second) {
        return first * second;
    }

    public static long divide(long first, long second) {
        return first / second;
    }

    private static boolean isValidateTextFormatArgs(String[] args) {
        if (args.length < 3 || (args.length % 2) == 0) {
            throw new IllegalArgumentException("올바르지 않은 연산자가 입력되었습니다.");
        }
        return true;
    }

    private static long calculate(String operator, long first, long second) {
        isValidateOperator(operator);

        long result = 0L;
        if (Operator.isEqualPlusOperator(operator)) {
            result = plus(first, second);
        }
        if (Operator.isEqualMinusOperator(operator)) {
            result = minus(first, second);
        }
        if (Operator.isEqualMultiplyOperator(operator)) {
            result = multiply(first, second);
        }
        if (Operator.isEqualDivideOperator(operator)) {
            result = divide(first, second);
        }

        return result;
    }

    private static boolean isValidateOperator(String operator) {
        if (operatorList.indexOf(operator) == -1) {
            throw new IllegalArgumentException("올바르지 않은 연산자가 입력되었습니다.");
        }
        return true;
    }

    public static long run(String arg) {
        isValidateInputArgument(arg);

        String[] args = arg.split(SPLIT_BLANK_REGEX);
        isValidateTextFormatArgs(args);
        long result = Long.parseLong(args[0]);
        long target;
        for (int i = 0; i < args.length - 2; i++) {
            if (i % 2 != 0) {
                i++;
            }
            target = Long.parseLong(args[i + 2]);
            result = calculate(args[i + 1], result, target);
        }
        return result;
    }

    private static boolean isValidateInputArgument(String arg) {
        if (arg == null || arg.equals("") || arg.length() == 0) {
            throw new IllegalArgumentException("문자열이 입력되지 않았습니다.");
        }
        return true;
    }

}
