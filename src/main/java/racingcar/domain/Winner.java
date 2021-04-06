package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    public List<RacingCar> findWinners(List<RacingCar> carList) {

        List<RacingCar> winnerList = new ArrayList<>();

        int maxLocation = getMaxLocation(carList);

        for (int i = 0; i < carList.size(); i++) {
            findWinner(carList, winnerList, maxLocation, i);
        }

        return winnerList;
    }

    private void findWinner(List<RacingCar> carList, List<RacingCar> winnerList, int maxLocation, int i) {
        if (carList.get(i).getLocation() == maxLocation) {
            winnerList.add(carList.get(i));
        }
    }

    private int getMaxLocation(List<RacingCar> carList) {
        int maxLocation = 0;

        for (int i = 0; i < carList.size(); i++) {
            maxLocation = getCarLocation(carList, maxLocation, i);
        }
        return maxLocation;
    }

    private int getCarLocation(List<RacingCar> carList, int maxLocation, int i) {
        if (maxLocation < carList.get(i).getLocation()) {
            maxLocation = carList.get(i).getLocation();
        }
        return maxLocation;
    }
}
