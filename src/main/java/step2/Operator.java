package step2;

import java.util.HashMap;
import java.util.Map;

public enum Operator implements Operation {

    PLUS("+"){
        @Override
        public int calculate(int first, int second) {
            return first + second;
        }
    },
    MINUS("-"){
        @Override
        public int calculate(int first, int second) {
            if(second == 0){
                throw new IllegalArgumentException("0으로 나눌 수 없습니다");
            }
            return first - second;
        }
    },
    DIVIDE("/"){
        @Override
        public int calculate(int first, int second) {
            return first / second;
        }
    },
    MULTIPLE("*"){
        @Override
        public int calculate(int first, int second) {
            return first * second;
        }
    };

    private static final Map<String, Operator> OPERATIONS = new HashMap<>();
    private final String operatorType;

    static {
        for (Operator operator : Operator.values()) {
            OPERATIONS.put(operator.getOperatorType(), operator);
        }
    }

    Operator(String operatorType) {
        this.operatorType = operatorType;
    }


    public String getOperatorType() {
        return operatorType;
    }

    public static Operator valueOfOperator(String operatorTypeKey){
        return OPERATIONS.get(operatorTypeKey);
    }

    public static boolean isContainOperator(String operatorTypeKey){
        if(OPERATIONS.get(operatorTypeKey) == null){
            return false;
        }
        return true;
    }

}
