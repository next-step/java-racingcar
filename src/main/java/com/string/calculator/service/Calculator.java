package com.string.calculator.service;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;
import java.util.function.Consumer;

public class Calculator {

    private Stack<Character> operatorStack;
    private Stack<Double> valueStack;
    private String manipulatedValue;
    private Integer lengthOfManipulatedValue;

    enum CalculatorType {

        OPERATION {
            @Override
            public <T> void doWork(Calculator calculator, T value) {
                calculator.addToOperatorStack((char) value);
            }
        },
        DIGIT {

        };

        public static CalculatorType getCalculatorType(Character type) {
            return Character.isDigit(type) ? DIGIT : OPERATION;
        }

        public abstract <T> void doWork(Calculator calculator, T value);
    }

    public Calculator(String inputValue) {
        operatorStack = new Stack<>();
        valueStack = new Stack<>();

        // 계산을 위한 초기화 작업
        init(inputValue);
    }

    public void addToOperatorStack(Character value) {
        operatorStack.add(value);
    }

    public void addToValueStack(Double value) {
        valueStack.add(value);
    }

    public Character popFromOperatorStack() {
        return operatorStack.pop();
    }

    public Double popFromValueStack() {
        return valueStack.pop();
    }

    private void init(String inputValue) {

        if (StringUtils.isEmpty(inputValue)) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }

        manipulatedValue = StringUtils.replace(inputValue, " ", "");
        lengthOfManipulatedValue = manipulatedValue.length();

        char firstCharacter = manipulatedValue.charAt(0);
        valueStack.add((double) Character.digit(firstCharacter, 10));
    }

    public Double evaluate() {

        for (int i = 1 ; i < lengthOfManipulatedValue ; i++) {
            char targetCharacter = manipulatedValue.charAt(i);
            if (Character.isDigit(targetCharacter)) {

            }


        }



        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {

            } else if (ch == '+') {
                operator.push(ch);
            } else if (ch == '-') {
                operator.push(ch);
            } else if (ch == '*') {
                operator.push(ch);
            } else if (ch == '/') {
                operator.push(ch);
            } else if (ch == ')') {
                char op = operator.pop();
                double v = values.pop();
                if (op == '+') {
                    v = values.pop() + v;
                } else if (op == '-') {
                    v = values.pop() - v;
                } else if (op == '*') {
                    v = values.pop() * v;
                } else if (op == '/') {
                    v = values.pop() / v;
                }
                values.push(v);
            } else {
                values.push((double) Character.digit(ch, 10));
            }
        }
        return values.pop();
    }

}
