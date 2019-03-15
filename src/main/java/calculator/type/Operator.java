package calculator.type;

public enum Operator {

    ADD("+") {
        public int calculate(int leftHandSideNumber, int rightHandSideNumber) {
            return leftHandSideNumber + rightHandSideNumber;
        }
    },

    SUBTRACT("-") {
        public int calculate(int leftHandSideNumber, int rightHandSideNumber) {
            return leftHandSideNumber - rightHandSideNumber;
        }
    },

    MULTIPLY("*") {
        public int calculate(int leftHandSideNumber, int rightHandSideNumber) {
            return leftHandSideNumber * rightHandSideNumber;
        }
    },

    DIVIDE("/") {
        public int calculate(int leftHandSideNumber, int rightHandSideNumber) {
            return leftHandSideNumber / rightHandSideNumber;
        }
    };

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract int calculate(int leftHandSideNumber, int rightHandSideNumber);

    public static Operator typeOf(String expression) {

        Operator[] operators = Operator.values();

        //TODO : 2Depth / if 조건문 분리하기
        for (Operator operator : operators) {
            if(operator.value.equals(expression)) {
                return operator;
            }
        }

        //TODO : Optional 사용해서 개선해보기 - 조금 더 공부한 뒤 적용
        //잘못된 값이 들어온것이므로, 에러 발생하는 방향으로 개선
        throw new IllegalArgumentException();
    }
}
