package calculator;

public enum Operator {

    Addition("+"){
        @Override
        public long action(long x, long y) {
            return x + y;
        }
    },
    Subtraction("-"){
        @Override
        public long action(long x, long y) {
            return x - y;
        }
    },
    Multiplication("*"){
        @Override
        public long action(long x, long y) {
            return x * y;
        }
    },
    Division("/"){
        @Override
        public long action(long x, long y) {
            if(y == 0){
                throw new IllegalArgumentException(DIVIDE_BY_ZERO_MSG);
            }
            return x / y;
        }
    };

    abstract public long action(long x, long y);

    private String operator;
    private final static String DIVIDE_BY_ZERO_MSG = "0으로는 나눌 수 없습니다.";
    private final static String NO_MATCH_OPERATOR_MSG = "사칙연산 기호가 아닌 값이 들어왔습니다.";

    public static Operator getOperator(String input){
        for(Operator value : values()){
            if(value.operator.equals(input)){
                return value;
            }
        }
        throw new IllegalArgumentException(NO_MATCH_OPERATOR_MSG);
    }

    Operator(String operator){
        this.operator = operator;
    }

}
