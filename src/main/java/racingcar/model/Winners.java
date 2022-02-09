package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private List<Car> raceReserts;

    public Winners(List<Car> cars) {
        this.raceReserts = new ArrayList<>(cars);
    }

    public ArrayList<String> winnerList() {
        int maxPosition = maximumDistance();
        ArrayList<String> winners = new ArrayList<>();

        for (Car raceResert : raceReserts) {
            if (raceResert.isMaxPosition((maxPosition))) {
                winners.add(raceResert.getCarName());
            }
        }
        return winners;
    }

    private int maximumDistance() {
        int maxPosition = 0;
        for (Car raceReserts : raceReserts) {
            maxPosition = raceReserts.checkMaxPosition(maxPosition);
        }
        return maxPosition;
    }

}
