package com.hskim.nextstep.step02;

import com.hskim.nextstep.step02.utils.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class StringCalculator {

    public static void main(String[] args) throws Exception {

        StringCalculator stringCalculator = new StringCalculator();
        String expression = stringCalculator.readExpression();
        Queue<String> exprQueue = stringCalculator.parseExpression(expression);
        System.out.println(stringCalculator.calculate(exprQueue));
    }

    private String readExpression() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    private Queue<String> parseExpression(String expression) {

        return Arrays.stream(expression.split(" "))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    /*
        throw IllegalArgumentExcetpion
        - if expression contains no Arithmetic operation sign.
    */
    private void validateExprQueue(Queue<String> exprQueue) {

        if(exprQueue == null || exprQueue.isEmpty()) {
            throw new IllegalArgumentException();
        }

        boolean isContainsIllegalArgument = exprQueue.stream()
                .filter(e -> !StringUtils.isNumeric(e))
                .filter(e -> !ArithmeticOperator.contains(e))
                .count() > 0;

         if(isContainsIllegalArgument) {
             throw new IllegalArgumentException();
         }
    }

    public int calculate(Queue<String> exprQueue) {

        validateExprQueue(exprQueue);

        int answer = 0;
        Stack<String> storage = new Stack<>();

        for(String expr : exprQueue) {

            if(storage.isEmpty() || StringUtils.isNumeric(storage.peek())) {

                storage.add(expr);
                continue;
            }

            answer = ArithmeticOperator.getArithmeticOperatorBySign(storage.pop()).calculate(storage.pop(), expr);
            storage.push(String.valueOf(answer));
        }

        return answer;
    }


}
