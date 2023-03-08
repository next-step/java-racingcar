package calculator.input;

public enum CalculatorInputType {

    NONE(00), EMPTY(10), NUMBER(20), CALCULATE(30), ERROR(99);

    private int code;

    CalculatorInputType(int code){
        this.code = code;
    };
}
