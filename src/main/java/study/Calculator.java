package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

class Calculator {
    public static final String SPACE = " ";
    public static final int OPERATOR_LENGTH = 1;

    private String formula;

    public Calculator(String formula) {
        this.formula = formula;
    }

    public long calculate() {
        if (Objects.isNull(formula) || formula.isEmpty()) {
            throw new IllegalArgumentException("계산식이 존재하지 않습니다.");
        }

        List<Parsed> parsingResult = new ArrayList<>();

        while (!Objects.isNull(formula)) {
            Parsed parsed = parse(formula);
            parsingResult.add(parsed);
            formula = parsed.remain;
        }

        long result = 0;
        for (Parsed parsed : parsingResult) {
            result = parsed.calculateWith(result);
        }
        return result;
    }

    private Parsed parse(String input) {
        try {
            String lhs = extractPrefixNumbers(input);
            String operator = input.substring(lhs.length() + SPACE.length(), lhs.length() + SPACE.length() + OPERATOR_LENGTH);
            String rhs = input.substring(input.indexOf(operator) + OPERATOR_LENGTH + SPACE.length());
            String remain = null;

            String tmp = rhs;
            if (isNotNumber(rhs)) {
                rhs = extractPrefixNumbers(tmp);
                remain = tmp.substring(rhs.length());
            }


            return new Parsed(lhs, operator, rhs, remain);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("연산자 사이에는 빈 공간이 한칸 있어야 합니다.", e);
        }
    }

    private String extractPrefixNumbers(String input) {
        String result = input.substring(0, input.indexOf(SPACE));
        if (isNotNumber(result) && !result.isEmpty()) {
            throw new IllegalArgumentException("연산자 사이에는 빈 공간이 한칸 있어야 합니다.");
        }
        return result;
    }

    private boolean isNotNumber(String input) {
        return !Pattern.matches("\\d+", input);
    }

    static class Parsed {
        private String lhs;
        private String rhs;
        private String operator;
        private String remain;

        public Parsed(String lhs, String operator, String rhs, String remain) {
            this.lhs = lhs;
            this.rhs = rhs;
            this.operator = operator;
            this.remain = remain;
        }

        private Long getLeftHandSide() {
            return Long.valueOf(lhs);
        }

        private Long getRightHandSize() {
            return Long.valueOf(rhs);
        }

        private boolean hasLeftHandSide() {
            return !lhs.isEmpty();
        }

        public long calculateWith(long defaultLhs) {
            long lhs = defaultLhs;
            if (hasLeftHandSide()) {
                lhs = getLeftHandSide();
            }

            switch (operator) {
                case "+":
                    return lhs + getRightHandSize();
                case "-":
                    return lhs - getRightHandSize();
                case "*":
                    return lhs * getRightHandSize();
            }

            if (!operator.equals("/")) {
                throw new IllegalArgumentException("올바른 연산자가 아닙니다.");
            }
            if (lhs % getRightHandSize() != 0) {
                throw new IllegalArgumentException("나눗셈은 정수로 떨어져야 합니다.");
            }

            return lhs / getRightHandSize();
        }

    }
}
