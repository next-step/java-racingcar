package racing_winner.domain;

import java.util.ArrayList;
import java.util.List;

public final class RacingResult {

    private List<Car> roundResult;

    public RacingResult(final List<Car> roundResult) {
        this.roundResult = roundResult;
    }

    public List<Car> findWinners(){
        List<Car> winners = new ArrayList<>();
        int maxDistance = findMaxDistance();

        roundResult.stream()
                .filter(car -> car.compareDistance(maxDistance))
                .forEach(winners::add);

        return winners;
    }

    public List<Car> getRoundResult() {
        return roundResult;
    }

    private int findMaxDistance(){
        int maxDistance = 0;
        for (Car car : roundResult) {
            maxDistance = car.findFartherDistance(maxDistance);
        }
        return maxDistance;
    }
}
