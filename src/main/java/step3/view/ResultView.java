package step3.view;

public class ResultView {
    public static void printRaceResult(String name, int score, String symbol) {
        System.out.printf("%5s : ", name);
        for (int i = 0; i < score; i++) {
            System.out.printf("%s", symbol);
        }
        System.out.println();
    }
}
