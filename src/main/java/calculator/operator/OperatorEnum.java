package calculator.operator;

public enum OperatorEnum {

    PLUS("+") {
        public double calculate(double operand1, double operand2) {
            return operand1 + operand2;
        }
    },
    MINUS("-") {
        public double calculate(double operand1, double operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLY("*") {
        public double calculate(double operand1, double operand2) {
            double result = operand1 * operand2;
            return Math.round(result * 100) / 100.0;
        }
    },
    DIVISION("/") {
        public double calculate(double operand1, double operand2) {
            double result = operand1 / operand2;
            return Math.round(result * 100) / 100.0;
        }
    };

    public abstract double calculate(double operand1, double operand2);

    private String keyword;

    OperatorEnum(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public static OperatorEnum getOperatorEnumFromKeyword(String operatorKeyword) {
        for (OperatorEnum operator : OperatorEnum.values()) {
            if (operator.getKeyword().equals(operatorKeyword)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("수식 중 사칙연산 기호가 잘못되었습니다.");
    }

    public static boolean isKeyword(String operatorKeyword) {
        for (OperatorEnum operator : OperatorEnum.values()) {
            if (operator.getKeyword().equals(operatorKeyword)) {
                return true;
            }
        }
        return false;
    }
}
