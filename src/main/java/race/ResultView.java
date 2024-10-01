package race;

import java.util.List;

public class ResultView {
    private static final String PIECE = "-";

    private static void printTitle() {
        System.out.println("실행 결과");
    }

    private static void printRound(int round) {
        System.out.println(round + "라운드");
    }

    public static void print(List<CarRaceGameHistory> histories) {
        System.out.println();
        printTitle();

        int currentRound = histories.get(0).getRound();
        printRound(currentRound);

        for (CarRaceGameHistory history : histories) {
            if (currentRound != history.getRound()) {
                System.out.println();
                currentRound = history.getRound();
                printRound(currentRound);
            }

            System.out.println(history.getCar().getId() + PIECE.repeat(history.getStep()));
        }
    }
}
