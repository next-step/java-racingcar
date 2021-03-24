package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    public List<RacingCar> whoisWin(List<RacingCar> carList) {

        List<RacingCar> winnerList = new ArrayList<>();

        int maxLocation = getMaxLocation(carList);

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getCarLocation().length() == maxLocation) winnerList.add(carList.get(i));
        }

        return winnerList;
    }


    private int getMaxLocation(List<RacingCar> carList) {
        int maxLocation = 0;

        for (int i = 0; i < carList.size(); i++) {
            if (maxLocation < carList.get(i).getCarLocation().length()) maxLocation = carList.get(i).getCarLocation().length();
        }

        return maxLocation;
    }
}
