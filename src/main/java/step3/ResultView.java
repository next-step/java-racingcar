package step3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ResultView {
    private int[] carPositions;
    private String[] resultCarPositions;

    public ResultView() {
    }

    public ResultView(int[] carPositions) {
        this.carPositions = carPositions;
        resultCarPositions = new String[carPositions.length];
    }

    public void settingresultCarPositions() {
        int length = carPositions.length;
        IntStream.range(0, length).forEach(i -> {
            appendDash(i);
        });
    }

    public void appendDash(int index) {
        StringBuilder builder = new StringBuilder();
        int carPosition = carPositions[index];
        IntStream.range(0, carPosition).forEach(i -> {
            builder.append("-");
        });

        resultCarPositions[index] = builder.toString();
    }

    public void printRacingResult() {
        Arrays.stream(resultCarPositions).forEach(System.out::println);
    }

    public String[] getResultCarPositions() {
        return resultCarPositions;
    }

}
