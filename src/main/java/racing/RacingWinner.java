package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingWinner {

    private final List<String> winners = new ArrayList<>();

    public RacingWinner(RacingRound racingRound) {
        List<Integer> positions = new ArrayList<>();
        Cars winnerCars = racingRound.getRoundResult(racingRound.size() - 1);

        int max = createMaxRank(positions, winnerCars);
        createWinners(winnerCars, max);
    }

    private void createWinners(Cars winnerCars, int max) {
        for (int i = 0; i < winnerCars.size(); i++) {
            if (max == winnerCars.getCar(i).getPosition()) {
                winners.add(winnerCars.getCar(i).getName());
            }
        }
    }

    private int createMaxRank(List<Integer> positions, Cars winnerCars) {
        for (int i = 0; i < winnerCars.size(); i++) {
            positions.add(winnerCars.getCar(i).getPosition());
        }
        int max = Collections.max(positions);
        return max;
    }

    public String getWinners() {
        return winners.toString();
    }
}
