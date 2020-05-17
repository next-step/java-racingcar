package step2;

public enum Operator {
    PLUS("+") {
        /**
         * left와 right를 더해준다.
         * 
         * @param left  : double, 더할 값
         * @param right : double, 더할 값
         * @return double, 더한 값을 반환
         */
        @Override
        public double calculate(double left, double right) {
            return left + right;
        }
    },
    /**
     * left에서 right를 뺀다.
     * 
     * @param left  : double, 뺄셈 대상
     * @param right : double, left에서 빼줄 값
     * @return double, left에서 right를 뺀 값을 반환
     */
    MINUS("-") {
        @Override
        public double calculate(double left, double right) {
            return left - right;
        }
    },
    /**
     * left와 right를 곱한다.
     * 
     * @param left  : double, 곱할 값
     * @param right : double, 곱할 값
     * @return double, 곱한 값을 반환
     */
    MULTIPLY("*") {
        @Override
        public double calculate(double left, double right) {
            return left * right;
        }
    },
    /**
     * left에서 right를 나눈다.
     * 
     * @param left  : double, 나눌 대상
     * @param right : double, 나눌 값
     * @return double, 나눈 값을 반환
     */
    DIVISION("/") {
        @Override
        public double calculate(double left, double right) {
            return left / right;
        }
    };

    public final String symbol;

    private Operator(String symbol) {
        this.symbol = symbol;
    }

    /**
     * left에서 right를 계산. 연산자에 따라 결과가 달라짐
     * 
     * @param left  : double, 계산 대상
     * @param right : double, 계산할 값
     * @return double, 계산한 값을 반환
     */
    public abstract double calculate(double left, double right);

    /**
     * 문자열(symbol)로 어떤 연산자인지 찾아서 반환
     * 
     * @param symbol : String 연산자 e.g."+"
     * @return Operator, 찾은 enum 객체
     * @throws IllegalArgumentException 사칙연산 기호(+, -, *, /) 가 아닐 경우
     */
    public static Operator findOperatorBySymbol(String symbol) throws IllegalArgumentException {
        Operator result = null;

        StringValidator.checkNullAndEmpty(symbol);

        for (Operator operator : Operator.values()) {
            result = getOperatorBySymbol(symbol, operator);
        }

        if (result == null) {
            throw new IllegalArgumentException("올바른 사칙연산 기호가 아닙니다.");
        }

        return result;
    }

    /**
     * 문자열(symbol)과 operator의 기호가 일치하면 해당 opeartor 반환
     * 
     * @param symbol   : String 연산자 e.g."+"
     * @param operator : Operator enum 객체
     * @return Operator, 일치하는 operator 반환 없을 시 null 반호나
     */
    private static Operator getOperatorBySymbol(String symbol, Operator operator) {
        Operator result = null;

        if (operator.symbol.equals(symbol)) {
            result = operator;
        }

        return result;
    }
}
