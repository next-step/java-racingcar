package step4racinggamewinner;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private Cars cars;
    private List<String> winnerNameList = new ArrayList<>();
    private Car baseLineCar;

    public Winners(Cars cars) {
        this.cars = cars;
        baseLineCar = this.cars.baseLineCar();
        winnerNameList.add(baseLineCar.carName());
    }

    public List<String> findWinner() {
        List<Integer> currentCarPositionList = cars.currentCarPositionList();
        for (int carIndex = 1; carIndex < currentCarPositionList.size(); carIndex++) {
            compareCars(currentCarPositionList, carIndex);
        }
        return winnerNameList;
    }

    private void compareCars(List<Integer> currentCarPositionList, int carIndex) {
        int baseLinePosition = baseLineCar.currentPosition();
        if (baseLinePosition > currentCarPositionList.get(carIndex)) {
            return;
        }
        if (baseLinePosition < currentCarPositionList.get(carIndex)) {
            winnerNameList.clear();
        }
        winnerNameList.add(cars.specificCarName(carIndex));
    }
}
