package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private int winRecord = 0;
    private List<RacingCar> winnerList = new ArrayList<RacingCar>();


    public List<RacingCar> findWinner(RacingCar[] cars) {
        for (RacingCar car : cars) {
            updateWinnerList(car);
        }
        return this.winnerList;
    }

    private List<RacingCar> updateWinnerList(RacingCar car) {
        if (car.getLocation() > winRecord) {
            winRecord = car.getLocation();
            winnerList = new ArrayList<RacingCar>();
            winnerList.add(car);
            return winnerList;
        }

        if (car.getLocation() == winRecord) {
            winnerList.add(car);
            return winnerList;
        }

        return winnerList;
    }
}
