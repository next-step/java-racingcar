package racingcar.model;

import racingcar.model.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Referee {
    private int winRecord = 0;
    private List<RacingCar> winnerList = new ArrayList<RacingCar>();


    public List<RacingCar> findWinner(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            updateWinnerList(car);
        }
        return this.winnerList;
    }

    private void updateWinnerList(RacingCar car) {
        int record = car.getPosition();

        if (record > winRecord) {
            winRecord = record;
            winnerList = new ArrayList<RacingCar>(Arrays.asList(car));
            return;
        }

        if (record == winRecord) {
            winnerList.add(car);
            return;
        }
    }
}
