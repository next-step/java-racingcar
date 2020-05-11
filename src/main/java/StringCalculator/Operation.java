package StringCalculator;

public enum Operation {

    PLUS("+"){
        @Override
        public double operate(double preNumber, double nextNumber) {
            return preNumber + nextNumber;
        }
    },
    MINUS("-"){
        @Override
        public double operate(double preNumber, double nextNumber) {
            return preNumber - nextNumber;
        }
    },
    MULTIPLY("*"){
        @Override
        public double operate(double preNumber, double nextNumber) {
            return preNumber * nextNumber;
        }
    },
    DIVISION("/"){
        @Override
        public double operate(double preNumber, double nextNumber) {
            return preNumber / nextNumber;
        }
    };

    private String operation;

    Operation(String operation) { this.operation = operation; };

    public double operate(double preNumber, double nextNumber) { return 0; };

    @Override
    public String toString() {
        return this.operation;
    }


}
