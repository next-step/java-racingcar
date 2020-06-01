package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    public String inputer(String input) {
        String[] inputArr = input.split(" ");
        if(inputArr.length < 3 || input.length() % 2 != 1){
            throw new IllegalArgumentException();
        }

        Queue<String> queue = new LinkedList<>();
        for(int i=0; i<inputArr.length; i++) {
            queue.offer(inputArr[i]);
        }

        int res = Integer.valueOf(queue.poll());

        while(!queue.isEmpty()) {
            String symbol = queue.poll();
            int b = Integer.valueOf(queue.poll());
            res = calculate(symbol, res, b);
        }

        return String.valueOf(res);
    }

    int calculate(String symbol, int a, int b) {
            return CalculatorType.calculate(symbol, a, b);
    }

}