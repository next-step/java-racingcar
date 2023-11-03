package racinggame;

import static java.lang.System.*;

import java.util.List;

public class ResultView {

    public static final String RESULT_SIGN = "실행 결과";
    private static final String DASH = "-";

    public static void br() {
        out.println();
    }

    public static void report(List<MovingDistance> report) {
        for (MovingDistance movingDistance : report) {
            out.println(createResult(movingDistance));
        }
        br();
    }

    private static String createResult(MovingDistance movingDistance) {
        return DASH.repeat(Math.max(0, movingDistance.distance()));
    }

    public static void resultSign() {
        out.println(RESULT_SIGN);
    }
}
