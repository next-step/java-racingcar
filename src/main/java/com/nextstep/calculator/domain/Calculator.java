package com.nextstep.calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Operator> operators = new ArrayList<>();
    private List<Number> numbers = new ArrayList<>();

    public Calculator(final List<Operator> operators, final List<Number> numbers) {
        this.operators = new ArrayList<>(operators);
        this.numbers = new ArrayList<>(numbers);
    }
}
