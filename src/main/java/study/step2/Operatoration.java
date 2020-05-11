package study.step2;

import study.step2.common.StringUtil;

import java.util.Arrays;
import java.util.List;

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

    private static List<Integer> numberList;
    private static List<String> operatorList;
    private final String symbol;


    private Operatoration(String symbol){
        this.symbol = symbol;
    }

    public abstract String apply(int x, int y);

    public static String calculate(String input){
        int result = 0;
        getSeparatelyExpression(input);
        result = getResult(result);
        return String.valueOf(result);
    }

    private static int getResult(int result) {
        for(int i = 0; i <= operatorList.size()-1; i++){
            result = Integer.parseInt(Operatoration.findSymbol(operatorList.get(i)).apply(numberList.get(0), numberList.get(1)));
            initNumberList(result);
        }
        return result;
    }

    private static void getSeparatelyExpression(String input) {
        numberList = new Number(StringUtil.seperateNumberAndOperator(input)).getNumbers();
        operatorList = new Operators(StringUtil.seperateNumberAndOperator(input)).getOperators();
    }

    private static void initNumberList(int result) {
        numberList.remove(0);
        numberList.remove(0);
        numberList.add(0, result);
    }

    private static Operatoration findSymbol(String symbol){

        return  Arrays.stream(Operatoration.values())
                .filter(value ->  value.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", symbol)));
    }
}