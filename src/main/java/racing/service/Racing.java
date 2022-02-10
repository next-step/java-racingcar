package racing.service;

import java.util.ArrayList;
import java.util.List;
import racing.domain.Car;
import racing.domain.Round;
import racing.vo.CarResult;
import racing.domain.RoundResult;

public class Racing {

    private final List<Car> cars;
    private final Round round;
    private final List<RoundResult> roundResults;
    private int roundNumber;

    public Racing(List<Car> cars, Round round, int roundNumber) {
        this(cars, round, new ArrayList<>(), roundNumber);
    }

    public Racing(List<Car> cars, Round round, List<RoundResult> roundResults, int roundNumber) {
        this.cars = cars;
        this.round = round;
        this.roundResults = roundResults;
        this.roundNumber = roundNumber;
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
        List<CarResult> carResult  = round.play(cars);
        roundResults.add(new RoundResult(carResult));
        roundNumber--;
    }

    public RoundResult getLastResult() {
        final int LAST_INDEX = roundResults.size() - 1;
        return roundResults.get(LAST_INDEX);
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }
}
