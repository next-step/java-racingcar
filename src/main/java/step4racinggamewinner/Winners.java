package step4racinggamewinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Winners {

    private Cars cars;
    private List<String> winnerNameList = new ArrayList<>();

    public Winners(Cars cars) {
        this.cars = cars;

    }

    public List<String> findWinner() {
        addWinnerNameToList(carNameAndPositionMap(), maxCarPosition());
        return winnerNameList;
    }

    public void addWinnerNameToList(Map<String, Integer> carNameAndPositionMap, int maxCarPosition) {
        for ( String carName : carNameAndPositionMap.keySet()) {
            if (carNameAndPositionMap.get(carName) == maxCarPosition) {
                winnerNameList.add(carName);
            }
        }
    }

    public Map<String, Integer> carNameAndPositionMap() {
        return cars.carNameAndPositions();
    }

    public int maxCarPosition() {
        return cars.maxCarPosition();
    }
    


}
