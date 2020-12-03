package calculator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class StringCalculator {

    private final StringValidator validator = new StringValidator();
    private final LinkedList<Integer> numbers = new LinkedList<>();
    private final LinkedList<String> symbols = new LinkedList<>();

    /* 사칙연산 함수 */
    public int plus(int a, int b) {
        return a + b;
    }
    public int minus(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        return a / b;
    }

    /**
     * 문자열 사칙연산 계산
     * @param input 입력값
     * @return 계산결과
     */
    public int calculate(String input) {
        int result = 0;
        setElements(input);
        Class<?>[] paramTypes = {int.class, int.class};
        for (String symbol : symbols) {
            Operator operator = Operator.findBySymbol(symbol);
            invokeCalculate(operator.getMethodName(), paramTypes);
        }
        if (numbers.peek() != null) {
            result = numbers.peek();
        }
        return result;
    }

    /**
     * 입력값 셋팅
     * @param input 입력값
     */
    private void setElements(String input) {
        if (!validator.valid(input)) {
            throw new IllegalArgumentException();
        }
        String[] elements = input.split("\\s");
        for (String element : elements) {
            setNumbers(element);
            setSymbols(element);
        }
    }

    /**
     * 숫자값 설정
     * @param element 입력요소
     */
    private void setNumbers(String element) {
        if (element.matches("\\d")) {
            numbers.offer(Integer.parseInt(element));
        }
    }

    /**
     * 사칙연산 기호 설정
     * @param element 입력요소
     */
    private void setSymbols(String element) {
        if (element.matches("\\D")) {
            symbols.offer(element);
        }
    }

    /**
     * 사칙연산 이름에 해당하는 사칙연산 함수 호출
     * @param methodName 함수명
     * @param paramTypes 파라미터 타입
     */
    private void invokeCalculate(String methodName, Class<?>[] paramTypes) {
        try {
            Method operatorMethod = this.getClass().getMethod(methodName, paramTypes);
            int result = (int) operatorMethod.invoke(this, numbers.poll(), numbers.poll());
            numbers.offerFirst(result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
