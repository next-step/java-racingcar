package step2;

/** Calculator 인터페이스
 * 두개의 숫자를 입력받아 사칙연산을 수행하는 인터페이스
 */

public interface Calculator {

    /**
     * 사칙연산을 수행하는 계산 메서드
     * "+" 기호면 덧셈
     * "-" 기호면 뺼셈
     * "*" 기호면 곱셈
     * "/" 기호면 나눗셈을 수행한다.
     * @param leftNumber
     * @param rightNumber
     *
     */
    int calculate(int leftNumber, int rightNumber );
}
