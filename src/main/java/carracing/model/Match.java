package carracing.model;


import java.util.ArrayList;
import java.util.List;

public class Match {
    List<Racer> racers = new ArrayList<>();

    public void addRacer(Racer racer) {
        racers.add(racer);
    }

    public Presenter progressDisplay() {
        Presenter presenter = new Presenter();
        for (Racer racer : racers) {
            presenter.addDisplay(racer.carName(), racer.recordPresentation());
        }
        return presenter;
    }

    public Presenter winnerDisplay() {
        List<Racer> winners = findWinners(racers);
        Presenter presenter = new Presenter();
        for (Racer winnerRacer : winners) {
            presenter.addDisplay(winnerRacer.carName(), winnerRacer.recordPresentation());
        }
        return presenter;
    }

    private List<Racer> findWinners(List<Racer> racers) {
        List<Racer> winners = new ArrayList<>();
        int winnerPosition = maxPosition(racers);
        for (Racer racer : racers) {
            winnerExtract(winners, winnerPosition, racer);
        }
        return winners;
    }

    private void winnerExtract(List<Racer> winners, int winnerPosition, Racer racer) {
        if (racer.isWinner(winnerPosition)) {
            winners.add(racer);
        }
    }

    private int maxPosition(List<Racer> racers) {
        int maxPosition = -1;
        for (Racer racer : racers) {
            maxPosition = Math.max(maxPosition, racer.finalPosition());
        }
        return maxPosition;
    }
}
