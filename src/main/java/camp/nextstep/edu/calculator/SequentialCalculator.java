package camp.nextstep.edu.calculator;

import camp.nextstep.edu.util.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SequentialCalculator implements StringCalculator<Integer> {
    private static final int SIZE_CALCULATION_TERMINATED = 1;
    private static final int CALCULATION_UNIT = 3;
    private static final int INDEX_FIRST_ELEMENT = 0;
    private static final int INDEX_SECOND_ELEMENT = 1;
    private static final int INDEX_THIRD_ELEMENT = 2;

    private final ExpressionValidator expressionValidator;

    public SequentialCalculator(ExpressionValidator expressionValidator) {
        this.expressionValidator = expressionValidator;
    }

    @Override
    public Integer calculate(String input) {
        expressionValidator.validate(input);

        final String[] splitString = input.split("\\s");
        final List<String> elements = Arrays.asList(splitString);
        return this.calculateRecursively(elements);
    }

    private Integer calculateRecursively(List<String> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new IllegalArgumentException("'elements' must not be null or empty");
        }
        // 종료 조건
        if (elements.size() == SIZE_CALCULATION_TERMINATED) {
            return ListUtils.getForInteger(elements, INDEX_FIRST_ELEMENT);
        }

        // 처음 3개의 원소들(숫자, 연산자, 숫자)을 계산
        final String result = this.processFirstOperator(elements);

        // 남은 원소들이 있다면, 계속 계산
        final List<String> remainingElements = this.getRemainingElements(elements);
        final List<String> nextElements = new ArrayList<>();
        nextElements.add(result);
        nextElements.addAll(remainingElements);
        return calculateRecursively(nextElements);
    }

    private String processFirstOperator(List<String> elements) {
        final Integer source = ListUtils.getForInteger(elements, INDEX_FIRST_ELEMENT);
        final OperatorType operatorType = ListUtils.getForOperatorType(elements, INDEX_SECOND_ELEMENT);
        final Integer target = ListUtils.getForInteger(elements, INDEX_THIRD_ELEMENT);
        final int result = operatorType.operate(source, target);
        return String.valueOf(result);
    }

    private List<String> getRemainingElements(List<String> elements) {
        final int size = elements.size();
        if (size <= CALCULATION_UNIT) {
            return Collections.emptyList();
        }
        return elements.subList(CALCULATION_UNIT, size);
    }
}
