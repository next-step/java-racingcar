package calculator;


/**
 * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
 * 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
 * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 * 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 * <p>
 * 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
 * 테스트할 수 있는 단위로 나누어 구현 목록을 만든다.
 * 덧셈
 * 뺄셈
 * 곱셈
 * 나눗셈
 * 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
 * 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
 * 사칙 연산을 모두 포함하는 기능 구현
 * 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다.
 * 반복적인 패턴을 찾아 반복문으로 구현한다.
 */
public class StringCalculator {

    private CalculatorValidation calculratorException;

    StringCalculator() {
        calculratorException = new CalculatorValidation();
    }

    public int calculate(String value) {
        String[] valueArr = value.split(" ");
        int result =  Integer.parseInt(valueArr[0]);
        for (int i = 0; i < valueArr.length - 2; i += 2) {
            calculratorException.checkException( valueArr[i + 1], Integer.parseInt(valueArr[i + 2]));
            result = calculate(result, valueArr[i + 1], Integer.parseInt(valueArr[i + 2]));
        }
        return result;
    }

    private int calculate(int firstValue, String expression, int lastValue) {
        if (expression.equals("+")) return plus(firstValue, lastValue);
        if (expression.equals("-")) return minus(firstValue, lastValue);
        if (expression.equals("*")) return multi(firstValue, lastValue);
        if (expression.equals("/")) return divide(firstValue, lastValue);
        throw new IllegalArgumentException("올바른 연산자가 아닙니다.");
    }

    public int plus(int firstValue, int lastValue) {
        return firstValue + lastValue;
    }

    public int minus(int firstValue, int lastValue) {
        return firstValue - lastValue;
    }

    public int multi(int firstValue, int lastValue) {
        return firstValue * lastValue;
    }

    public int divide(int firstValue, int lastValue) {
        return firstValue / lastValue;
    }


}
