package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Car> raceResults;

    public Winners(List<Car> raceResults) {
        this.raceResults = raceResults;
    }

    public ArrayList<String> winnerList() {
        int maxPosition = maximumDistance();
        ArrayList<String> winners = new ArrayList<>();

        for (Car raceResult : raceResults) {
            if (raceResult.isMaxPosition((maxPosition))) {
                winners.add(raceResult.getCarName());
            }
        }
        return winners;
    }

    private int maximumDistance() {
        int maxPosition = 0;
        for (Car raceResult : raceResults) {
            maxPosition = raceResult.checkMaxPosition(maxPosition);
        }
        return maxPosition;
    }

}
