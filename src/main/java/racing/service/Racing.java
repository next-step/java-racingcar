package racing.service;

import java.util.ArrayList;
import java.util.List;
import racing.domain.Car;
import racing.domain.RacingInfo;
import racing.domain.Round;
import racing.domain.CarResultVO;
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
        while (isInProgress(roundNumber)) {
            runGame();
        }
    }

    private boolean isInProgress(int roundNumber) {
        return roundNumber > 0;
    }

    private void runGame() {
        List<CarResultVO> result = round.play(cars);
        results.add(new RoundResult(result));
        roundNumber--;
    }

    public RoundResult getLastResult() {
        final int LAST_INDEX = results.size() - 1;
        return results.get(LAST_INDEX);
    }

    public List<RoundResult> getRoundResults() {
        return results;
    }
}
