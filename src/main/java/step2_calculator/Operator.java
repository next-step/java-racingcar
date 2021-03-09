package step2_calculator;

import java.util.Arrays;

public enum Operator {
    CALC_PLUS("+", (num1, num2) -> num1+num2),
    CALC_MINUS("-", (num1, num2) -> num1-num2),
    CALC_MULTIPLY("*", (num1, num2) -> num1*num2),
    CALC_DIVIDE("/", (num1, num2) -> num1/num2);

    private final String representation;
    private final OperatorInterface operations;

    Operator(String representation, OperatorInterface operations) {
        this.representation = representation;
        this.operations = operations;
    }

    public static Operator validate(String input){
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.representation.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산기호입니다."));
    }

    /*
     * 연산자와 피연산자를 입력받아 계산하여 반환한다.
     * @param operator 연산자 문자열, num1 피연산자1, num2 피연산자2
     * @return 계산한 결과값
     *  */
    public int operate(int num1, int num2){
        return this.operations.operate(num1, num2);
    }

}
