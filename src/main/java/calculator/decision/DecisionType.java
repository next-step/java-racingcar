package calculator.decision;

public enum DecisionType {

    NONE(00), PLUS(10), MINUS(20), MULTIPLY(30), DIVIDE(40), ERROR(99);
    private int code;
    DecisionType(int code){
        this.code = code;
    };
}
