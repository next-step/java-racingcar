package calculator;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    public String inputer(String input) {
        String[] inputArr = input.split(" ");

        if(inputArr.length < 3 || inputArr.length % 2 != 1){
            throw new IllegalArgumentException("입력값 오류");
        }

        Queue<String> queue = new LinkedList<>();
        for (int i=0; i<inputArr.length; i++) {
            queue.offer(inputArr[i]);
        }

        int result = 0;
        try {
            result = Integer.valueOf(queue.poll());

            while(!queue.isEmpty()) {
                String symbol = queue.poll();
                int num = Integer.valueOf(queue.poll());
                result = CalculatorType.calculate(symbol, result, num);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닌 입력값 오류");
        }

        return String.valueOf(result);
    }

}