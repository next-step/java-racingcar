package humbledude.stringcalculator;

public interface Token {

    /**
     * Operator 에서 연산 세부 내용 정의해서 씁시다
     *
     * @param operand1 앞의 숫자
     * @param operand2 뒤의 숫자
     * @return 연산 결과
     */
    default Token operation(Token operand1, Token operand2) {
        throw new RuntimeException("저 숫자인데요.. 이거 나오면 안되는데..");
    }

    /**
     * Operand 에서 true 로 정의해서 씁시다
     * @return 나는 숫자인가?
     */
    default boolean isOperand() {
        return false;
    }

    /**
     * Operand 에서만 정의해서 씁시다
     * @return integer 값
     */
    default int getValue() {
        throw new RuntimeException("저 연산자인데요.. 이거 나오면 안되는데..");
    }
}
