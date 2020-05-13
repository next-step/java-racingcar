package step2;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringCalculator {
    /**
     * 문자열 안의 숫자와 연산자를 분리하여 계산한다.
     * 
     * @param param : String, '숫자 연산자 숫자' 의 순서로 이루어진 문자열 e.g."2 + 3 + 4"
     * @return 계산 결과 값을 반환한다.
     */
    public String calculate(String param) {
        Deque<String> calculatorDequeue = new ArrayDeque<>();
        double left = 0;
        double right = 0;
        double result = 0;
        String operator = "";
        String temp = "";

        try {
            checkNull(param);

            param = removeWhiteSpace(param);

            initCalculatorDequeue(param, calculatorDequeue);

            while (2 < calculatorDequeue.size()) {
                left = Double.parseDouble(calculatorDequeue.poll());
                operator = calculatorDequeue.poll();
                right = Double.parseDouble(calculatorDequeue.poll());

                temp = calculate(operator, left, right);

                calculatorDequeue.push(temp);
            }

            result = Double.parseDouble(calculatorDequeue.poll());

            if (result % 1 == 0) {
                return String.valueOf((int) result);
            }
        } catch (IllegalArgumentException e) {
            // 메인로직에서 예외 처리 시 테스트 코드의 expecting이 throwable이라고 나오는데, 이렇게 하는게 잘못 된 방식인건지
            System.out.println("StringCalculator.calculate(String param) : " + e.getMessage() + "\nparam : " + param);
        } 

        return String.valueOf(result);
    }

    /**
     * 연산자에 맞게 left와 right를 계산한다.
     * 
     * @param operator : String, 연산자
     * @param left     : double, 좌항
     * @param right    : double, 우항
     * @return String, 계산 결과 반환
     */
    public String calculate(String operator, double left, double right) {
        checkOperator(operator);

        // else 없애라는게 이렇게 하는게 맞는지
        // return문이 하나가 되는게 좋다고 알고있었는데 어떻게 해야 하는지
        if (operator.equals("+")) {
            return plus(left, right);
        }
        if (operator.equals("-")) {
            return minus(left, right);
        }
        if (operator.equals("*")) {
            return multiply(left, right);
        }
        if (operator.equals("/")) {
            return division(left, right);
        }

        return null;
    }

    /**
     * 공백을 모두 제거
     * 
     * @param param : String, 공백을 제거할 문자열
     * @return String, 공백이 제거된 문자열
     */
    public String removeWhiteSpace(String param) {
        return param.replaceAll(" ", "");
    }

    /**
     * 계산기 덱(dequeue) 초기화
     * <li>문자열(param)의 숫자와 연산자를 분리하여 덱에 삽입한다.</li>
     * <li>문자열(param)은 '숫자 연산자 숫자'의 순서로 이루어져야 한다. e.g. "2+3+4"</li>
     * 
     * @param param             : String, 덱에 넣을 문자열
     * @param calculatorDequeue : Dequeue, 계산할 문자열을 담을 덱
     * @throws IllegalArgumentException '숫자 연산자 숫자' 의 순서가 아닌 경우 e.g. "2++3+4"
     */
    public void initCalculatorDequeue(String param, Deque<String> calculatorDequeue) throws IllegalArgumentException {
        // private으로 감춰야할것같은데 그럴 경우 테스트는?
        // 새로운 객체를 생성할 필요가 없기 때문에 타입을 void로 했는데, 이런 메소드 같은 경우도 return을 명시해주는것이 좋은 것인지
        String[] splitedParamArr = param.split("");
        StringBuffer temp = new StringBuffer();
        boolean afterOperator = true;

        for (int i = 0; i < splitedParamArr.length; i++) {
            checkEmpty(splitedParamArr[i]);

            if (isNumber(splitedParamArr[i])) {
                temp.append(splitedParamArr[i]);
                afterOperator = false;
            }
            if (!isNumber(splitedParamArr[i])) {
                if (afterOperator) {
                    throw new IllegalArgumentException("수식이 잘못되었습니다.");
                }
                calculatorDequeue.add(temp.toString());
                calculatorDequeue.add(splitedParamArr[i]);
                temp.setLength(0);
                afterOperator = true;
            }
        }

        if (temp.length() != 0) {
            calculatorDequeue.add(temp.toString());
        }
    }

    /**
     * 문자열이 숫자인지 확인한다
     * 
     * @param param : String, 확인할 문자열
     * @return boolean, 숫자일 경우 true, 아닐 경우 false 반환
     */
    public boolean isNumber(String param) {
        // try-catch 비용이 큰 것으로 알고 있는데 이런식으로 판단하는 로직을 사용해도 괜찮은건지
        try {
            Double.parseDouble(param);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * left와 right를 더해준다.
     * 
     * @param left  : double, 더할 값
     * @param right : double, 더할 값
     * @return String, 더한 값을 반환
     */
    public String plus(double left, double right) {
        return String.valueOf(left + right);
    }

    /**
     * left에서 right를 뺀다.
     * 
     * @param left  : double, 뺄셈 대상
     * @param right : double, left에서 빼줄 값
     * @return String, left에서 right를 뺀 값을 반환
     */
    public String minus(double left, double right) {
        return String.valueOf(left - right);
    }

    /**
     * left와 right를 곱한다.
     * 
     * @param left  : double, 곱할 값
     * @param right : double, 곱할 값
     * @return String, 곱한 값을 반환
     */
    public String multiply(double left, double right) {
        return String.valueOf(left * right);
    }

    /**
     * left에서 right를 나눈다.
     * 
     * @param left  : double, 나눌 대상
     * @param right : double, 나눌 값
     * @return String, 나눈 값을 반환
     */
    public String division(double left, double right) {
        return String.valueOf(left / right);
    }

    /**
     * null일경우 IllegalArgumentException throw
     * 
     * @param param : String 판단할 문자열
     */
    public void checkNull(String param) {
        if (param == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
    }

    /**
     * 빈 문자열이거나 빈 공백 문자열일 경우 IllegalArgumentException throw
     * 
     * @param param : String 판단할 문자열
     * @throws IllegalArgumentException
     */
    public void checkEmpty(String param) throws IllegalArgumentException {
        String[] splitedStringsBySpace = param.split(" ");

        for (String splitedString : splitedStringsBySpace) {
            if (!splitedString.isEmpty()) {
                return;
            }
        }

        throw new IllegalArgumentException("입력값이 빈 문자열 입니다.");
    }

    /**
     * 입력받은 문자열(param)이 사칙연산 기호가 아니면 IllegalArgumentException
     * 
     * @param param : String, 판단할 문자열
     * @throws IllegalArgumentException
     */
    public void checkOperator(String param) throws IllegalArgumentException {
        String[] correctOperators = { "+", "-", "*", "/" };

        for (String correctOperator : correctOperators) {
            if (correctOperator.equals(param)) {
                return;
            }
        }

        throw new IllegalArgumentException("올바른 사칙연산 기호가 아닙니다.");
    }

}
