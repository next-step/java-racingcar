package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidCalculatorFormulaException;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Operator> operators = new ArrayList<>();
    private List<Number> numbers = new ArrayList<>();

    public Calculator(final List<Operator> operators, final List<Number> numbers) {
        validate(operators, numbers);

        this.operators = new ArrayList<>(operators);
        this.numbers = new ArrayList<>(numbers);
    }

    public Number calculate() {
        return operators.get(0).operate(numbers.get(0), numbers.get(1));
    }

    private void validate(List<Operator> operators, List<Number> numbers) {
        if (operators.size() == 0 || numbers.size() == 0) {
            throw new InvalidCalculatorFormulaException("수식과 숫자 모두 있어야 합니다.");
        }
        if (operators.size() + 1 != numbers.size()) {
            throw new InvalidCalculatorFormulaException("계산할 수 없는 수식 조건입니다.");
        }
    }
}
