package calculator;

public enum Opserator {

    ADD{
        @Override
        public int getResult(CalculatorParamValue paramValue){
            return paramValue.getFirstValue() + paramValue.getSecondValue();
        }
    },
    DIV{
        @Override
        public int getResult(CalculatorParamValue paramValue){
            return paramValue.getFirstValue() / paramValue.getSecondValue();
        }
    },
    MUL{
        @Override
        public int getResult(CalculatorParamValue paramValue){
            return paramValue.getFirstValue() * paramValue.getSecondValue();
        }
    },
    SUB{
        @Override
        public int getResult(CalculatorParamValue paramValue){
            return paramValue.getFirstValue() - paramValue.getSecondValue();
        }
    }
    ;

    abstract int getResult(CalculatorParamValue paramValue);
}
