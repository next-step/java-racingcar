package step2;

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

    private final String operatorType;


    Operator(String operatorType) {
        this.operatorType = operatorType;
    }


    public String getOperatorType() {
        return operatorType;
    }
}
