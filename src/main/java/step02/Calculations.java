package step02;

import java.util.LinkedList;
import java.util.Queue;

public class Calculations {
    public int calculate(int first, String operator, int second) {
        return OperationManager.calculate(operator, first, second);
    }

    public int calculate(String data) {
        Queue<String> symbolList = new LinkedList<>();
        Queue<Integer> numberList = new LinkedList<>();
        String[] inputData = data.split(" ");
        int result = 0;

        for (String input : inputData) {
            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                symbolList.add(input);
            } else {
                numberList.add(Integer.parseInt(input));
            }
        }

        while (!symbolList.isEmpty()) {
            if (result == 0) {
                result = calculate(numberList.poll(), symbolList.poll(), numberList.poll());
            } else {
                result = calculate(result, symbolList.poll(), numberList.poll());
            }
        }

        return result;
    }
}
