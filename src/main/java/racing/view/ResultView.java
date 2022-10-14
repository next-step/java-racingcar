package racing.view;

import java.util.List;

public class ResultView {
    private static final String DASH = "-";

    public static void init() {
        System.out.println("실행 결과");
    }

    public void result(List<Integer> distances) {
        for (int dis : distances) {
            if(dis > 0) {
                System.out.print(DASH.repeat(dis));
                System.out.println("");
            }
        }
    }
}
