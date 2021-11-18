package carracing;

import java.util.List;

public class ResultView {
    private ResultView() {}

    public static void printSteps(List<Integer> steps) {
        steps.forEach(step -> {
            System.out.println(stepLine(step));
        });
        System.out.println();
    }

    private static String stepLine(int step) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < step; i++) {
            line.append("-");
        }
        return line.toString();
    }
}
