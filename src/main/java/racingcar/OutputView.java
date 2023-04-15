package racingcar;

public class OutputView {

    public static void printCarTraceUntilNow(int totalDistance) {
        for (int i = 0; i < totalDistance; i++) {
            System.out.print("-");
        }
    }
}
