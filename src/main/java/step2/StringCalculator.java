package step2;

import java.util.*;

/**
 * 문자열 사칙 연산 계산기
 */
public class StringCalculator {

    private static final String NUMBERS_REGEXP = "[0-9]";
    private static final String OPERATOR_REGEXP = "[+|-|*|/]";
    private static final String EMPTY_SPACE = "";
    private static final String WHITESPACE_DELIMITER = "\\s";

    private static final List<String> FOUR_RULE_CALCULATION = Arrays.asList("+", "-", "*", "/");

    public static final String PLUS_EXPRESSION = "+";
    public static final String SUBT_EXPRESSION = "-";
    public static final String MULT_EXPRESSION = "*";
    public static final String DIVI_EXPRESSION = "/";

    public static final String DIVIDE_BY_ZERO = "divide by zero";
    public static final String NOT_MATCH_FOUR_RULE_CALCULATION = "사칙 연산 문자열에 포함하지 않은 문자열이 존재합니다.";

    private final Queue<Integer> operationValue = new LinkedList<>();
    private final Queue<String> operationExpressions = new LinkedList<>();

    private static final Integer ZERO = 0;

    /**
     * 유효성 검사 -> 사용자 입력 데이터 가공 -> 반복적인 연산 -> 결과
     *
     * @param input 사용자의 데이터 입력 값
     * @return 사칙연산 최종 결과 값
     */
    public int apply(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException();
        }

        dataExtractAndConvertProcess(input);

        // 연속적인 연산 과정 처리
        Integer result = operationValue.poll();

        while (!operationValue.isEmpty()) {
            int nextValue = operationValue.poll();
            String operation = operationExpressions.poll();

            result = forLoopOperation(result, nextValue, operation);
        }
        return result;
    }

    private void dataExtractAndConvertProcess(String input) {
        String[] operationValues = getSplit(input, OPERATOR_REGEXP, EMPTY_SPACE, WHITESPACE_DELIMITER);
        String[] operationExpressions = getSplit(input, NUMBERS_REGEXP, EMPTY_SPACE, WHITESPACE_DELIMITER);

        operationValues = deleteEmptyBucket(operationValues);
        operationExpressions = deleteEmptyBucket(operationExpressions);

        for (String s : operationExpressions) {
            this.operationExpressions.offer(s);
        }

        for (String s : operationValues) {
            this.operationValue.offer(Integer.parseInt(s));
        }
    }

    private String[] deleteEmptyBucket(String[] originData) {
        List<String> tmpList = new ArrayList<>();
        for (String item : originData) {
            tmpList.add(isEmpty(item));
        }
        return tmpList.toArray(new String[ZERO]);
    }

    // 연산자
    private int forLoopOperation(Integer result, Integer operationValue, String operator) {
        if(!FOUR_RULE_CALCULATION.contains(operator)) {
            throw new IllegalArgumentException("사칙 연산 외에 문자가 포함되어 있습니다.");
        }
        if (PLUS_EXPRESSION.equals(operator)) {
            result = plus(result, operationValue);
        }
        if (SUBT_EXPRESSION.equals(operator)) {
            result = subtract(result, operationValue);
        }
        if (MULT_EXPRESSION.equals(operator)) {
            result = multiply(result, operationValue);
        }
        if (DIVI_EXPRESSION.equals(operator)) {
            result = divide(result, operationValue);
        }
        return result;
    }

    // operation
    public Integer plus(Integer a, Integer b) {
        return a + b;
    }
    public Integer subtract(Integer minuend, Integer subtrahend) {
        return minuend - subtrahend;
    }
    public Integer multiply(Integer multiplicand, Integer multiplier) {
        return multiplicand * multiplier;
    }

    public Integer divide(Integer dividend, Integer divisor) {
        if (dividend.equals(ZERO)) {
            throw new ArithmeticException(DIVIDE_BY_ZERO);
        }
        return dividend / divisor;
    }

    // 배열 데이터 Split 처리
    public String[] getSplit(String origin, String regex, String completed, String delimiter) {
        return origin.replaceAll(regex, completed).split(delimiter);
    }

    // validation
    public boolean isContainsSymbol(String input) { // 주어진 문자열의 문자가 사칙연산에 속하는지 여부 판단
        String[] s = getSplit(input, NUMBERS_REGEXP, EMPTY_SPACE, WHITESPACE_DELIMITER);
        for (String item : s) {
            checkOperator(item);
        }
        return true;
    }

    // 문자열 값만 확인하여 사칙연산자에 포함되어 있는지 확인
    private String checkOperator(String item) {
        if(!isBlank(item) && !FOUR_RULE_CALCULATION.contains(item)) {
            throw new IllegalArgumentException(NOT_MATCH_FOUR_RULE_CALCULATION);
        }
        return item;
    }

    public boolean isBlank(String input) {
        return Objects.isNull(input) || input.trim().isEmpty();
    }

    private String isEmpty(String item) {
        if(!item.isEmpty()) {
            return item;
        }
        return null;
    }
}
