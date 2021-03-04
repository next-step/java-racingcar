package calculator;

import java.util.function.BiFunction;
import java.util.function.Function;

public enum Operator {
    ADD("+", (num1 , num2) -> num1 + num2) ,
    SUBTRACT("-", (num1 , num2) -> num1 - num2),
    MULTIPLY("*", (num1 , num2) -> num1 * num2),
    DIVIDE("/", (num1 , num2) -> num1 / num2);

    private String operator;
    private BiFunction<Integer,Integer,Integer> calculation;

    Operator(String operator, BiFunction<Integer,Integer,Integer> calculation) {
        this.operator = operator;
        this.calculation = calculation;
    }

    public String getName() {
        return operator;
    }

    public BiFunction<Integer, Integer, Integer> getCalculation() {
        return calculation;
    }

    /*
     *  @param String operatorString 연산자 값을 가져온다.
     *  미리 지정해둔 enum과 operatorString 값을 비교하여 결과 값 반환
     * */
    public static Operator converterOperator(String operatorString){
        for(Operator operator : values()){
            if(operator.getName().equalsIgnoreCase(operatorString)){
                return operator;
            }
        }
        throw new IllegalArgumentException("연산자 값이 잘못되었습니다. 다시 한번 확인해주세요.");
    }
}
