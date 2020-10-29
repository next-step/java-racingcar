package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

class Calculator {
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

    private static class SubFormula {
        static final String SPACE = " ";
        static final int SIGN_LENGTH = 1;
        public static SubFormula create(String formula) {
            try {
                String leftHandSide = extractLeftHandSide(formula);
                String sign = formula.substring(leftHandSide.length() + SPACE.length(), leftHandSide.length() + SPACE.length() + SIGN_LENGTH);
                String rightHandSide = formula.substring(formula.indexOf(sign) + SIGN_LENGTH + SPACE.length());
                String remain = null;

                String tmp = rightHandSide;
                if (isNotNumber(rightHandSide)) {
                    rightHandSide = extractLeftHandSide(tmp);
                    remain = tmp.substring(rightHandSide.length());
                }


                return new SubFormula(leftHandSide, sign, rightHandSide, remain);
            } catch (StringIndexOutOfBoundsException e) {
                throw new IllegalArgumentException("연산자 사이에는 빈 공간이 한칸 있어야 합니다.", e);
            }
        }

        private final String leftHandSide;
        private final String rightHandSide;
        private final String sign;
        private final String remain;

        public SubFormula(String leftHandSide, String sign, String rightHandSide, String remain) {
            this.leftHandSide = leftHandSide;
            this.rightHandSide = rightHandSide;
            this.sign = sign;
            this.remain = remain;
        }

        public long calculateWith(long defaultLhs) {
            long leftHandSide = defaultLhs;
            if (hasLeftHandSide()) {
                leftHandSide = getLeftHandSide();
            }

            return Operator.valueOfSign(sign).apply(leftHandSide, getRightHandSize());
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
            return Long.valueOf(leftHandSide);
        }

        private Long getRightHandSize() {
            return Long.valueOf(rightHandSide);
        }

        private boolean hasLeftHandSide() {
            return !leftHandSide.isEmpty();
        }
    }

}
