package study.step2;

public enum OperatorEnum {
    PLUS( "+" ){
        @Override
        public int operation(int firstOperand, int secondOperand) {
            return firstOperand + secondOperand;
        }
    },
    MINUS( "-" ) {
        @Override
        public int operation(int firstOperand, int secondOperand) {
            return firstOperand - secondOperand;
        }
    },
    MULTIPLY( "*" ) {
        @Override
        public int operation(int firstOperand, int secondOperand) {
            return firstOperand * secondOperand;
        }
    },
    DIVIDE( "/" ) {
        @Override
        public int operation(int firstOperand, int secondOperand) {

            if(secondOperand == 0 )
                throw new IllegalArgumentException();
            return firstOperand / secondOperand;

        }
    };

    OperatorEnum(String operator) {
        this.operator = operator;
    }

    private final String operator;
    public abstract int operation(int firstOperand, int secondOperand);

    public static OperatorEnum getOperatorEnum(String operator){

        for (OperatorEnum value : OperatorEnum.values()) {
            if(value.operator.equals(operator))
                return value;
        }

        throw new IllegalArgumentException();
    }
}
