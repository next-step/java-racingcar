package step2;

import java.util.ArrayDeque;
import java.util.Deque;

public class StringCalculator extends Calculator {
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
            StringValidator.checkNull(param);

            param = removeWhiteSpace(param);

            initCalculatorDequeue(param, calculatorDequeue);

            while (2 < calculatorDequeue.size()) {
                left = Double.parseDouble(calculatorDequeue.poll());
                operator = calculatorDequeue.poll();
                right = Double.parseDouble(calculatorDequeue.poll());

                temp = String.valueOf(calculate(operator, left, right));

                calculatorDequeue.push(temp);
            }

            result = Double.parseDouble(calculatorDequeue.poll());

            if (result % 1 == 0) {
                return String.valueOf((int) result);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("StringCalculator.calculate(String param) : " + e.getMessage() + "\nparam : " + param);
            return "error";
        }

        return String.valueOf(result);
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
            StringValidator.checkEmpty(splitedParamArr[i]);

            if (StringValidator.isNumber(splitedParamArr[i])) {
                temp.append(splitedParamArr[i]);
                afterOperator = false;
            }
            if (!StringValidator.isNumber(splitedParamArr[i])) {
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
}
