package carracing.model;


import carracing.present.RacingDisplayVO;

import java.util.ArrayList;
import java.util.List;

public class Match {
    List<Racer> racers = new ArrayList<>();

    public void addRacer(Racer racer) {
        racers.add(racer);
    }

    public List<RacingDisplayVO> progressDisplay() {
        List<RacingDisplayVO> racingDisplayVOs = new ArrayList<>();
        for (Racer racer : racers) {
            racingDisplayVOs.add(new RacingDisplayVO(racer));
        }
        return racingDisplayVOs;
    }

    public List<RacingDisplayVO> winnerDisplay() {
        List<RacingDisplayVO> racingDisplayVOs = new ArrayList<>();
        List<Racer> winners = findWinners(racers);
        for (Racer winner : winners) {
            racingDisplayVOs.add(new RacingDisplayVO(winner));
        }
        return racingDisplayVOs;
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
