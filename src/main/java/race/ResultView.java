package race;

import java.util.List;

public class ResultView {
    private static final String PIECE = "-";

    private static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void print(List<CarRaceGameHistory> histories) {
        System.out.println();
        printTitle();

        int round = histories.get(0).getRound();
        for (CarRaceGameHistory history : histories) {
            System.out.println(PIECE.repeat(history.getStep()));

            if (round != history.getRound()) {
                System.out.println();
                round = history.getRound();
            }
        }
    }
}
