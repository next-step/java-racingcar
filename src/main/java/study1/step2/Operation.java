package study1.step2;

public enum Operation implements Operator{
    PLUS("+"){
        @Override
        public int calculate(int result, int nextNumber){
            return result+nextNumber;
        }
    },
    SUBTRACTION("-"){
        @Override
        public int calculate(int result, int nextNumber){
            return result-nextNumber;
        }
    },
    MULTIPLICATION("*"){
        @Override
        public int calculate(int result, int nextNumber){
            return result*nextNumber;
        }
    },
    DIVISION("/"){
        @Override
        public int calculate(int result, int nextNumber){
            return result/nextNumber;
        }
    };

    private final String operationSymbol;

    Operation(String symbol){
        this.operationSymbol = symbol;
    }

    public String getOperationSymbol(){
        return this.operationSymbol;
    }
}
