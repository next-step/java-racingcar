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

}
