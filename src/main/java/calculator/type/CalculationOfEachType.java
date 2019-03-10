package calculator.type;

public enum CalculationOfEachType {

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

    CalculationOfEachType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract int calculrate(int leftHandSideNumber, int rightHandSideNumber);
}
