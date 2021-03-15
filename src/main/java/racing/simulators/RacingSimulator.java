package racing.simulators;

import racing.models.Racing;
import racing.models.Round;
import racing.models.Rounds;
import racing.views.RoundView;
import racing.views.View;
import racing.views.WinnersView;

public class RacingSimulator {
    private final Racing racing;
    private final int attemptsCount;

    public RacingSimulator(Racing racing, int attemptsCount) {
        this.racing = racing;
        this.attemptsCount = attemptsCount;
    }

    public void start() {
        startRace();
        System.out.println("\n실행 결과");
        showResult();
    }

    private void startRace() {
        while (racing.hasRun(attemptsCount)) {
            racing.runRace();
        }
    }

    private void showResult() {
        final Rounds rounds = racing.getRounds();

        final View<Void, Round> roundView = new RoundView();
        for (Round round : rounds) {
            roundView.show(round);
            System.out.println();
        }

        new WinnersView().show(racing);
    }
}
