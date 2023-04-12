package racing;

import java.util.List;

public class ResultView {
    private static final String DASH = "-";

    public static void showRepeatedDashWithCount(List<Integer> counts) {
        counts.forEach(count -> System.out.println(DASH.repeat(count)));
        System.out.println();
    }
}
