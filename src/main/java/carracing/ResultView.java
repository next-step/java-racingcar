package carracing;

import java.util.List;

public class ResultView {
    private static final StringBuilder builder = new StringBuilder();

    private ResultView() {}

    public static void printSteps(List<Integer> steps) {
        steps.forEach(step -> {
            System.out.println(stepLine(step));
        });
        System.out.println();
    }

    private static String stepLine(int step) {
        builder.delete(0, builder.length());
        for (int i = 0; i < step; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
