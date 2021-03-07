package step02;

import java.util.LinkedList;
import java.util.Queue;

public class StringCalculations {

    private static final int CALCULATIONS_RESULT_INIT = 0;

    public int calculate(int first, String operator, int second) {
        return OperationManager.calculate(operator, first, second);
    }

    public int calculate(String data) {
        if(StringUtils.isBlank(data)) throw new IllegalArgumentException();
        Queue<String> symbolList = new LinkedList<>();
        Queue<Integer> numberList = new LinkedList<>();
        String[] inputData = data.split(" ");
        int result = CALCULATIONS_RESULT_INIT;

        for (String input : inputData) {
            if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
                symbolList.add(input);
                continue;
            }
            numberList.add(Integer.parseInt(input));
        }

        while (!symbolList.isEmpty()) {
            if (result == 0) {
                result = calculate(numberList.poll(), symbolList.poll(), numberList.poll());
                continue;
            }
            result = calculate(result, symbolList.poll(), numberList.poll());
        }

        return result;
    }
}
