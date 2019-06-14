package calculator;

import java.util.Map;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    public static final String REGEX_PATTERN = "^(\\d+)(?:\\s+[\\+\\-\\*\\/]+\\s+(\\d+))*$";
    private int result;

    String[] split(String input) {
        validateDelimiters(input);
        validateBlank(input);
        return input.split(" ");
    }

    private void validateDelimiters(String checkString){
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        if(!pattern.matcher(checkString).find()){
            throw new IllegalArgumentException("구분자는 공백을 사용합니다.");
        }
    }

    private void validateBlank(String input) {
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException("문자열을 입력하세요. ex) 4 + 2 / 3 ..");
        }
    }

    public int calculate(String input) {
        String[] stringArray = split(input);
        result = parseInt(stringArray[0]);
        for (int index = 1; index < stringArray.length; index++) {
            operator(stringArray, index);
        }
        return result;
    }

    private void operator(String[] strArr, int index) {
        if (index % 2 == 1) {
            Operator operator = Operator.from(strArr[index]);
            result = calculate(result, operator, parseInt(strArr[index+1]));
        }
    }

    private int parseInt(String num) {
        return Integer.parseInt(num);
    }

    int calculate(int num, Operator operator, int num2) {
        return operator.calculator(num, num2);
    }

    enum Operator {
        PLUS('+', (num1, num2) -> num1 + num2),
        MINUS('-', (num1, num2) -> num1 - num2),
        MULTIPLY('*', (num1, num2) -> num1 * num2),
        DIVIDE('/', (num1, num2) -> {
            validateDivision(num2);
            return num1 / num2;
        });

        private final char symbol;
        private final IntBinaryOperator expression;
        private static final Map<String, Operator> symbolToEnum = Stream.of(values()).collect(Collectors.toMap(Operator::getSymbol, operator -> operator));

        Operator(char symbol, IntBinaryOperator expression) {
            this.symbol = symbol;
            this.expression = expression;
        }

        public int calculator(int num1, int num2) {
            return expression.applyAsInt(num1, num2);
        }

        private static void validateDivision(int number) {
            if (number == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
        }

        public String getSymbol() {
            return String.valueOf(symbol);
        }

        public static Operator from(String symbol) {
            return Optional.ofNullable(symbolToEnum.get(symbol))
                    .orElseThrow(() -> new IllegalArgumentException(symbol + "은 지원하지 않는 연산기호입니다."));
        }
    }
}
