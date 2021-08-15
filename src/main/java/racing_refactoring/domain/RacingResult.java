package racing_refactoring.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private List<Car> carList;

    public RacingResult(final List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getRoundResult() {
        return carList;
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = findMaxDistance();

        carList.stream()
                .filter(car -> car.compareDistance(maxDistance))
                .forEach(winners::add);

        return winners;
    }

    public int findMaxDistance(){
        int maxDistance = 0;
        for (Car car : carList) {
            maxDistance = car.findFartherDistance(maxDistance);
        }
        return maxDistance;
    }
}
