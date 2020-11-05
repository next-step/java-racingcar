package calculator;

import java.util.Arrays;

public enum OperatorEnum {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    final private String operator;


    OperatorEnum(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static OperatorEnum getOperation(String value) {
        for(int i=0; i<values().length; i++){
            if(values()[i].getOperator().equals(value)){
                System.out.println("@@@"+values()[i]);
                return values()[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
