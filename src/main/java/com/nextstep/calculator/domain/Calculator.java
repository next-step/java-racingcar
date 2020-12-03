package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidCalculatorFormulaException;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final int FIRST_NUMBER_INDEX = 0;
    private static final int SECOND_NUMBER_INDEX = 1;
    private static final int NEXT_CALCULATE_TARGET_INDEX = 2;

    private List<Operator> operators = new ArrayList<>();
    private List<Number> numbers = new ArrayList<>();

    public Calculator(final List<Operator> operators, final List<Number> numbers) {
        validate(operators, numbers);

        this.operators = new ArrayList<>(operators);
        this.numbers = new ArrayList<>(numbers);
    }

    public Number calculate() {
        operators.forEach(operator -> {
            Number number = operator.operate(numbers.get(FIRST_NUMBER_INDEX), numbers.get(SECOND_NUMBER_INDEX));

            numbers = numbers.subList(NEXT_CALCULATE_TARGET_INDEX, numbers.size());

            numbers.add(FIRST_NUMBER_INDEX, number);
        });

        return numbers.get(FIRST_NUMBER_INDEX);
    }

    private void validate(final List<Operator> operators, final List<Number> numbers) {
        if (operators.size() == 0 || numbers.size() == 0) {
            throw new InvalidCalculatorFormulaException("수식과 숫자 모두 있어야 합니다.");
        }
        if (operators.size() + 1 != numbers.size()) {
            throw new InvalidCalculatorFormulaException("계산할 수 없는 수식 조건입니다.");
        }
    }
}
