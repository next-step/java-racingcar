package calculator.operator;

public enum OperatorEnum {

    PLUS("+", new PlusOperator()),
    MINUS("-", new MinusOperator()),
    MULTIPLY("*", new MultiplyOperator()),
    DIVISION("/", new DivisionOperator());

    private String keyword;
    private Operator operator;

    OperatorEnum(String keyword, Operator operator) {
        this.keyword = keyword;
        this.operator = operator;
    }

    public String getKeyword() {
        return keyword;
    }

    public Operator getOperator() {
        return operator;
    }

    public static Operator getOperator(String operatorKeyword) {
        for (OperatorEnum operator : OperatorEnum.values()) {
            if (operator.getKeyword().equals(operatorKeyword)) {
                return operator.getOperator();
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
