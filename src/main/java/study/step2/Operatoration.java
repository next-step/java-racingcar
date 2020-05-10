package study.step2;

import study.step2.common.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public enum Operatoration {
    ADD("+"){
        @Override
        public String apply(int x, int y) {
            return String.valueOf(x+y);
        }
    },

    MINUS("-") {
        @Override
        public String apply(int x, int y) {
            return String.valueOf(x-y);
        }
    },

    MULTIPLY("*"){
        @Override
        public String apply(int x, int y) {
            return String.valueOf(x*y);
        }
    },

    DIVISION("/") {
        @Override
        public String apply(int x, int y) {
            return String.valueOf(x/y);
        }
    };

    private final String symbol;


    private Operatoration(String symbol){
        this.symbol = symbol;
    }

    public abstract String apply(int x, int y);

    public static String calculate(String input){

        List<Integer> numberList = new Number(StringUtil.seperateNumberAndOperator(input)).getNumbers();
        List<String> operatorList = new Operators(StringUtil.seperateNumberAndOperator(input)).getOperators();

        for(int i = 0; i <= operatorList.size()-1; i++){
            System.out.println("i>>>"+i);
            System.out.println(Operatoration.findSymbol(operatorList.get(i)).apply(numberList.get(i), numberList.get(i+1)));
        }

        return null;//Operatoration.findSymbol(operatorList.get(0)).apply(numberList.get(0),numberList.get(1));
    }

    private static Operatoration findSymbol(String symbol){

        return  Arrays.stream(Operatoration.values())
                .filter(value ->  value.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", symbol)));
    }
}
