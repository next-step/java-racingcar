package step3;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ResultView {

    public static final String DASH = "-";
    public static void generateUI(Map<Integer, AtomicInteger> cars) {
        for (Map.Entry<Integer, AtomicInteger> entry :cars.entrySet()) {
            drawDash(entry.getValue().intValue());
        }
        System.out.print("\n");

    }

    public static void startUI() {
        System.out.println("실행결과");
    }

    private static void drawDash(int count) {
        for (int i = 0; i <= count; i++) {
            System.out.print(DASH);
        }
        System.out.print("\n");
    }
}
