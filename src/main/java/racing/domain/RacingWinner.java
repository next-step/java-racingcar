package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingWinner {

    private final List<String> winners = new ArrayList<>();

    public RacingWinner(RacingRound racingRound) {
        Cars winnerCars = racingRound.getLastRoundResult();
        int max = createMaxRank(winnerCars);
        createWinners(winnerCars, max);
    }

    private int createMaxRank(Cars winnerCars) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < winnerCars.size(); i++) {
            positions.add(winnerCars.getCar(i).getPosition());
        }

        return Collections.max(positions);
    }

    private void createWinners(Cars winnerCars, int max) {
        for (int i = 0; i < winnerCars.size(); i++) {
            addWinners(winnerCars, max, i);
        }
    }

    private void addWinners(Cars winnerCars, int max, int i) {
        if (max == winnerCars.getCar(i).getPosition()) {
            winners.add(winnerCars.getCar(i).getName());
        }
    }

    public String getWinners() {
        return winners.toString();
    }
}
