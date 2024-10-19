package racinggamewinner.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Winners {

    private Cars cars;
    private WinnerList winnerNameList;

    public Winners(Cars cars) {
        this.cars = cars;
        this.winnerNameList = new WinnerList(new ArrayList<>());
    }

    public List<String> findWinner() {
        return winnerNameList.findWinner(carNameAndPositionMap(), maxCarPosition());
    }

    public Map<String, Integer> carNameAndPositionMap() {
        return cars.carNameAndPositions();
    }

    public int maxCarPosition() {
        return cars.maxCarPosition();
    }


}
