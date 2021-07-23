package calculator;

public enum Operator {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private String operator;

    Operator(String operator){
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static Operator valueOfString(String str) {
        for (Operator i : Operator.values()) {
            if (str.equals(i.getOperator())) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

}
