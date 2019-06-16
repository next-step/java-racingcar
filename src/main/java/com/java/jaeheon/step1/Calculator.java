package com.java.jaeheon.step1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Calculator {
    String[] inputArray;
    Validator validator = new Validator();

    List<Integer> extractNumber = new LinkedList<Integer>();
    List<String> extractOperator = new LinkedList<String>();

    public Calculator(String input) {
        this.inputArray = input.split(" ");
        validator.isNotBlank(input);
        validator.validateSize(inputArray.length);
    }

    public int run (){
        extractor();
        return calculator();
    }

    private void extractor() {
        String number;
        String symbol;
        int size = inputArray.length;

        for (int i = 1; i < size; i += 2) {
            number = inputArray[i - 1];
            symbol = inputArray[i];

            if (validator.isNumber(number)) {
                extractNumber.add(Integer.parseInt(number));
            }
            extractOperator.add(symbol);
        }

        if (validator.isNumber(inputArray[size - 1])) {
            extractNumber.add(Integer.parseInt(inputArray[size - 1]));
        }
    }

    private int calculator() {
        Iterator<String> operatorIterator = extractOperator.iterator();

        int output = 0;
        while (operatorIterator.hasNext()) {
            String operator = operatorIterator.next();
            int operand1 = extractNumber.get(0);
            int operand2 = extractNumber.get(1);

            output = Operator.OperatorChecker(operator).calculator(operand1, operand2);
            extractNumber.set(0, output);
        }
        return output;
    }
}
