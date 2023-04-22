package carracing.model;


import carracing.present.RacingDisplayVO;

import java.util.ArrayList;
import java.util.List;

public class Match {
    List<Racer> racers = new ArrayList<>();

    public void addRacer(Racer racer) {
        racers.add(racer);
    }

    public RacingDisplayVO progressDisplay() {
        RacingDisplayVO racingDisplayVO = new RacingDisplayVO();
        for (Racer racer : racers) {
            racingDisplayVO.addDisplay(racer.carName(), racer.positionPresentation());
        }
        return racingDisplayVO;
    }

    public RacingDisplayVO winnerDisplay() {
        List<Racer> winners = findWinners(racers);
        RacingDisplayVO racingDisplayVO = new RacingDisplayVO();
        for (Racer winnerRacer : winners) {
            racingDisplayVO.addDisplay(winnerRacer.carName(), winnerRacer.positionPresentation());
        }
        return racingDisplayVO;
    }

    private List<Racer> findWinners(List<Racer> racers) {
        List<Racer> winners = new ArrayList<>();
        int winnerPosition = maxPosition(racers);
        for (Racer racer : racers) {
            if (racer.isWinner(winnerPosition)) {
                winners.add(racer);
            }
        }
        return winners;
    }

    private int maxPosition(List<Racer> racers) {
        int maxPosition = -1;
        for (Racer racer : racers) {
            maxPosition = Math.max(maxPosition, racer.finalPosition());
        }
        return maxPosition;
    }
}
