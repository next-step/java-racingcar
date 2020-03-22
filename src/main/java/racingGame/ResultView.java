package racingGame;

public class ResultView {

    public static void printResult(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.printf("-");
        }
    }
}
