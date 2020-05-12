package com.string.calculator.service;

import com.string.calculator.model.OperationType;
import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

public class Calculator {

    private Stack<Character> operatorStack;
    private Stack<Double> valueStack;
    private String manipulatedValue;
    private Integer lengthOfManipulatedValue;

    public Calculator(String inputValue) {
        operatorStack = new Stack<>();
        valueStack = new Stack<>();

        // 계산을 위한 초기화 작업
        init(inputValue);
    }

    public Double evaluate() {

        for (int i = 1; i < lengthOfManipulatedValue; i++) {
            char targetCharacter = manipulatedValue.charAt(i);
            OperationType operationType = OperationType.getOperationType(targetCharacter);
            operationType.doWork(operatorStack, valueStack, targetCharacter);
        }

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
}
