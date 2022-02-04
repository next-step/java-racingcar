package racing.service;

import java.util.ArrayList;
import java.util.List;
import racing.domain.Car;
import racing.domain.RacingInfo;
import racing.domain.Round;
import racing.domain.RoundResult;

public class Racing {

    private final List<Car> cars;
    private final Round round;
    private final List<RoundResult> results;
    private int roundNumber;

    public Racing(RacingInfo info) {
        cars = info.getCars();
        round = info.getRound();
        roundNumber = round.getRoundNumber();
        results = new ArrayList<>();
    }

    public void race() {
        while (runGame()) {
            final RoundResult result = round.play(cars);
            results.add(result);
        }
    }

    private boolean runGame() {
        return roundNumber-- > 0;
    }

    public List<Car> getLastResult() {
        final int LAST_INDEX = results.size() - 1;
        return results.get(LAST_INDEX).getCars();
    }

    public List<RoundResult> getTotalRoundResults() {
        return results;
    }
}
