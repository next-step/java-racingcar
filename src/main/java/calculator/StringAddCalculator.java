package calculator;

import util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {

    public int add(String input) {
        if(StringUtils.isNullOrEmpty(input) ) {
            return 0;
        }

        List<Integer> operands = getOperands(input);

        return getSum(operands);
    }

    List<Integer> getOperands(String input) {

        List<Integer> operands = new ArrayList<>();

        String[] splittedInput = input.split(",|:");

        for( String str : splittedInput ) {
            operands.add(parseOperand(str));
        }

        return operands;
    }

    private int parseOperand(String str) {
        Integer operand = Integer.parseInt(str);

        if( operand.intValue() < 0 ) {
            throw new RuntimeException();
        }

        return operand.intValue();
    }

    private int getSum(List<Integer> operands) {
        return operands.stream().mapToInt(i -> i.intValue()).sum();
    }

}