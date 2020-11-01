package study1.step2;

import java.util.Arrays;

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

    public boolean isSameSymbol(String symbol){
        return operationSymbol.equals(symbol);
    }

    public static int calculate(String[] inputList, int index, int result){
        if(index % 2 == 0){
            return result;
        }
        return updateAnswer(inputList[index], result, Integer.parseInt(inputList[index+1]));
    }

    static int updateAnswer(String symbol, int a, int b){
        return Arrays.stream(values())
                .filter(operator -> operator.isSameSymbol(symbol))
                .findFirst().orElseThrow(IllegalArgumentException::new)
                .calculate(a, b);
    }
}
