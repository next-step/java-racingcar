package me.daeho.step3.ui;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ResultView {
    private final static String CAR_PATH = "-";

    private ResultView() {}

    public static ResultView create() {
        return new ResultView();
    }

    public void showResult(int[] carPositions) {
        Arrays.stream(carPositions).forEach(this::showPathByCar);
        System.out.println();
    }

    private void showPathByCar(int carPosition) {
        final StringBuilder sb = new StringBuilder();
        IntStream.range(0, carPosition).forEach(pos -> sb.append(CAR_PATH));
        System.out.println(sb.toString());
    }
}
