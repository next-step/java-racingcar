package calculator;


import calculator.exception.InvalidFormulaException;
import util.StringUtils;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

/*
    사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
    입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
    나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.

    메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
*/
public class StringCalculator implements Calculator {
    private static final String basicSeparator = " ";

    private String rebaseInput(String input) {
        // 두칸이상의 공백이 있다면 한칸으로 치환
        input = input.replaceAll("\\s{2,}", " ");
        return input;
    }

    private void validate(String input) {
        // 요구 사항 :: 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
        if (StringUtils.isEmpty(input))
            throw new IllegalArgumentException("공백으로 이루어진 문자열은 계산할 수 없습니다.");
    }

    private Deque<CalculationElement> toElements(String input) {
        // 입력 받은 문자열을 ' ' 단위로 잘라 CalculationElement으로 감싼 후 Deque으로 반환
        return Arrays.stream(input.split(basicSeparator))
                .map(CalculationElement::new)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private void exec(Deque<CalculationElement> elements) {
        /*
            문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
            예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
        */
        while(elements.size() > 1) { // 마지막 하나의 숫자가 남을때 까지 연산
            // 가장 앞쪽에 위치한 3개의 Element를 사용해 연산 후 결과로 바꾼다.
            int leftNumber = pollElement(elements)
                    .toInt()
                    .orElseThrow(InvalidFormulaException::new);
            Operator operator = pollElement(elements)
                    .toOperator()
                    .orElseThrow(() ->
                            new IllegalArgumentException("사칙 연산 기호가 아닙니다.")
                    );
            int rightNumber = pollElement(elements)
                    .toInt()
                    .orElseThrow(InvalidFormulaException::new);

            int calResult = operator.calculation(leftNumber, rightNumber);
            elements.addFirst(new CalculationElement(calResult));
        }
    }

    private CalculationElement pollElement(Deque<CalculationElement> elements) {
        if (elements.size() == 0)
            throw new InvalidFormulaException();
        return elements.poll();
    }

    @Override
    public int calculation(String input) {
        input = rebaseInput(input);
        validate(input);

        Deque<CalculationElement> elements = toElements(input);
        exec(elements);

        return pollElement(elements)
                .toInt()
                .orElseThrow(InvalidFormulaException::new);
    }
}
