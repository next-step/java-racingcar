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

        List<SubFormula> subFormulas = new ArrayList<>();

        while (!Objects.isNull(formula)) {
            SubFormula subFormula = SubFormula.create(formula);
            subFormulas.add(subFormula);
            formula = subFormula.remain;
        }

        long result = 0;
        for (SubFormula subFormula : subFormulas) {
            result = subFormula.calculateWith(result);
        }
        return result;
    }

    static class SubFormula {
        private final String lhs;
        private final String rhs;
        private final String operator;
        private final String remain;

        public SubFormula(String lhs, String operator, String rhs, String remain) {
            this.lhs = lhs;
            this.rhs = rhs;
            this.operator = operator;
            this.remain = remain;
        }

        public static SubFormula create(String formula) {
            try {
                String lhs = extractLeftHandSide(formula);
                String operator = formula.substring(lhs.length() + SPACE.length(), lhs.length() + SPACE.length() + OPERATOR_LENGTH);
                String rhs = formula.substring(formula.indexOf(operator) + OPERATOR_LENGTH + SPACE.length());
                String remain = null;

                String tmp = rhs;
                if (isNotNumber(rhs)) {
                    rhs = extractLeftHandSide(tmp);
                    remain = tmp.substring(rhs.length());
                }


                return new SubFormula(lhs, operator, rhs, remain);
            } catch (StringIndexOutOfBoundsException e) {
                throw new IllegalArgumentException("연산자 사이에는 빈 공간이 한칸 있어야 합니다.", e);
            }
        }

        private static String extractLeftHandSide(String input) {
            String result = input.substring(0, input.indexOf(SPACE));
            if (isNotNumber(result) && !result.isEmpty()) {
                throw new IllegalArgumentException("연산자 사이에는 빈 공간이 한칸 있어야 합니다.");
            }
            return result;
        }

        private static boolean isNotNumber(String input) {
            return !Pattern.matches("\\d+", input);
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
