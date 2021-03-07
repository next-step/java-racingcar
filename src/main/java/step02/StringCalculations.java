package step02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class StringCalculations {

    public int calculate(int first, String operator, int second) {
        return OperationManager.calculate(operator, first, second);
    }

    public int calculate(String data) {
        if (StringUtils.isBlank(data)) throw new IllegalArgumentException();

        String result;
        Queue<String> inputData = new LinkedList<>();
        inputData.addAll(Arrays.asList(data.split(" ")));

        if (isFinishCalculation(inputData)) {
            return Integer.parseInt(data);
        }

        result = String.valueOf(calculate(Integer.parseInt(inputData.poll()), inputData.poll(), Integer.parseInt(inputData.poll())));

        if (isFinishCalculation(inputData)) {
            return Integer.parseInt(result);
        }

        String remainData = inputData.stream().collect(Collectors.joining(" "));
        result += " " + remainData;

        return calculate(result);
    }

    private boolean isFinishCalculation(Queue<String> data) {
        return data.size() <= 1;
    }
}
