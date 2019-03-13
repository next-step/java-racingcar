package calculator.type;

public enum Operator {

    ADD("+") {
        public int calculrate(int leftHandSideNumber, int rightHandSideNumber) {
            return leftHandSideNumber + rightHandSideNumber;
        }
    },

    SUBTRACT("-") {
        public int calculrate(int leftHandSideNumber, int rightHandSideNumber) {
            return leftHandSideNumber - rightHandSideNumber;
        }
    },

    MULTIPLY("*") {
        public int calculrate(int leftHandSideNumber, int rightHandSideNumber) {
            return leftHandSideNumber * rightHandSideNumber;
        }
    },

    DIVIDE("/") {
        public int calculrate(int leftHandSideNumber, int rightHandSideNumber) {
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

    public abstract int calculrate(int leftHandSideNumber, int rightHandSideNumber);

    public static Operator typeOf(String expression) {

        Operator[] operators = Operator.values();

        //TODO : 2Depth / if 조건문 분리하기
        for (Operator operator : operators) {
            if(operator.value.equals(expression)) {
                return operator;
            }
        }

        //TODO : Optional 사용해서 개선해보기
        return null;
    }
}
