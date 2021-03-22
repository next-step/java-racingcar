package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<RacingCar> winnerList;

    public List<RacingCar> whoisWin(List<RacingCar> carList, GameSet gameSet) {

        winnerList = new ArrayList<>();

        for (int i = 0; i < carList.size(); i++) {
            isWin(carList.get(i), gameSet);
        }

        return winnerList;
    }

    private void isWin(RacingCar racingCar, GameSet gameSet) {
        if (racingCar.getCarLocation().length() == gameSet.getGivenRound()) {
            winnerList.add(racingCar);
        }
    }
}
