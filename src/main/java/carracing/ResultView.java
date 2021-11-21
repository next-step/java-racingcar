package carracing;

import java.util.List;

public class ResultView {
    private static final StringBuilder builder = new StringBuilder();

    public static void printRounds(List<Track.Round> rounds) {
        rounds.forEach(round -> {
            printRound(round);
            System.out.println();
        });
    }

    private static void printRound(Track.Round round) {
        round.getSteps().forEach(step -> {
            System.out.println(stepLine(step));
        });
    }

    private static String stepLine(int step) {
        builder.delete(0, builder.length());
        for (int i = 0; i < step; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
