package step02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class StringCalculations {

    private int calculate(int first, String operator, int second) {
        return OperationManager.calculate(operator, first, second);
    }

    public int calculate(String data) {
        if (StringUtils.isBlank(data)){
            throw new IllegalArgumentException("입력값이 비었습니다.");
        }

        String result;
        Queue<String> inputData = new LinkedList<>(Arrays.asList(data.split(" ")));

        if (isFinishCalculation(inputData)) {
            return Integer.parseInt(data);
        }

        result = String.valueOf(calculate(Integer.parseInt(Objects.requireNonNull(inputData.poll())), inputData.poll(), Integer.parseInt(Objects.requireNonNull(inputData.poll()))));

        if (isFinishCalculation(inputData)) {
            return Integer.parseInt(result);
        }

        String remainData = String.join(" ", inputData);
        result += " " + remainData;

        return calculate(result);
    }

    private boolean isFinishCalculation(Queue<String> data) {
        return data.size() <= 1;
    }
}
