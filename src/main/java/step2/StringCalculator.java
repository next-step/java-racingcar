package step2;

import java.util.Queue;

import static step2.Constants.STRING_NOT_FOUND_EXCEPTION;
import static step2.Validator.isBlank;
import static step2.Validator.isValidation;

/**
 * 문자열 사칙 연산 계산기
 */
public class StringCalculator {

    public Integer calculate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(STRING_NOT_FOUND_EXCEPTION);
        }
        if(!isValidation(input)) {
            throw new IllegalArgumentException(Constants.CANNOT_CALCULATE_FORMULA);
        }
        // 사용자의 입력 값을 관리할 Context
        MathContext mathContext = new MathContext(input);

        // 연산 처리하기 위해 가공된 데이터 셋
        Queue<Integer> numbers = mathContext.getNumbers();
        Queue<Operator> operations = mathContext.getOperations();

        return process(numbers, operations);
    }

    private Integer process(Queue<Integer> numbers, Queue<Operator> operations) {
        Integer result = numbers.poll();

        while (!numbers.isEmpty() && !operations.isEmpty()) {
            Integer nextValue = numbers.poll();
            Operator operatorExpression = operations.poll();

            // 연산자 확인 -> 연산
            result = operatorExpression.calculate(result, nextValue);
        }
        return result;
    }

}
