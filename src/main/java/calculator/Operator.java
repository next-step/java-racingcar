package calculator;

public enum Operator {

    PLUS('+'), SUBSTRACT('-'), MULTIPLY('*'), DIVIDE('/') ;


    private char operator;
    Operator(char operator){
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }
}
