package calculator.type;

public enum CalculationByOperator {

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

    CalculationByOperator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract int calculrate(int leftHandSideNumber, int rightHandSideNumber);

    public static CalculationByOperator convertTypeByOperator(String expression) {

        if ("+".equals(expression)) {
            return CalculationByOperator.ADD;
        }

        if ("-".equals(expression)) {
            return CalculationByOperator.SUBTRACT;
        }

        if ("*".equals(expression)) {
            return CalculationByOperator.MULTIPLY;
        }

        if ("/".equals(expression)) {
            return CalculationByOperator.DIVIDE;
        }

        return null;
    }
}
