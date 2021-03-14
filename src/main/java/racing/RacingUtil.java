package racing;

import java.util.List;

public class RacingUtil {
    public static void start(Racing racing) {
        while (racing.hasNext()) {
            racing.runRace();
        }
    }

    public static void showResult(Racing racing) {
        final List<Round> rounds = racing.getRounds();

        final RoundView roundView = new RoundView();

        for (Round round : rounds) {
            roundView.show(round);
            System.out.println();
        }

        new WinnersView().show(rounds.get(rounds.size() - 1));
    }
}
