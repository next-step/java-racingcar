package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> findWinners(List<RacingCar> carList) {

        List<RacingCar> winnerList = new ArrayList<>();

        int maxLocation = getMaxLocation(carList);

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getLocation() == maxLocation) winnerList.add(carList.get(i));
        }

        return winnerList;
    }

    private int getMaxLocation(List<RacingCar> carList) {
        int maxLocation = 0;

        for (int i = 0; i < carList.size(); i++) {
            if (maxLocation < carList.get(i).getLocation()) maxLocation = carList.get(i).getLocation();
        }

        return maxLocation;
    }
}
